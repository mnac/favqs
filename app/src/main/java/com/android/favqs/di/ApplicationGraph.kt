package com.android.favqs.di

import android.app.Application
import android.content.Context
import com.android.favqs.data.repository.AccountRepositoryImpl
import com.android.favqs.data.repository.QuotesRepositoryImpl
import com.android.favqs.data.service.local.PersistedPreferences
import com.android.favqs.data.service.remote.HeadersInterceptor
import com.android.favqs.data.service.remote.SessionInterceptor
import com.android.favqs.data.service.remote.account.AccountRemoteService
import com.android.favqs.data.service.remote.quote.QuotesRemoteService
import com.android.favqs.data.source.account.AccountDataSource
import com.android.favqs.data.source.account.AccountLocalDataSource
import com.android.favqs.data.source.account.AccountRemoteDataSource
import com.android.favqs.data.source.quotes.QuotesDataSource
import com.android.favqs.data.source.quotes.QuotesLocalDataSource
import com.android.favqs.data.source.quotes.QuotesRemoteDataSource
import com.android.favqs.domain.repository.AccountRepository
import com.android.favqs.domain.repository.QuotesRepository
import com.android.favqs.frameworks.LocalPreferences
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        PersistedPreferencesModule::class,
        NetworkServiceModule::class,
        ServiceRemoteModule::class,
        DataSourceLocalModule::class,
        DataSourceRemoteModule::class,
        RepositoryModule::class,
        SubComponentsModule::class
    ]
)
interface ApplicationGraph {
    fun landingComponent(): LandingComponent.Factory
    fun loginComponent(): LoginComponent.Factory
    fun quotesComponent(): QuotesComponent.Factory
}

@Module(subcomponents = [LandingComponent::class, LoginComponent::class, QuotesComponent::class])
class SubComponentsModule {}

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun accountRepository(
        localDataSource: AccountDataSource.Local,
        remoteDataSource: AccountDataSource.Remote,
        sessionInterceptor: SessionInterceptor
    ): AccountRepository {
        return AccountRepositoryImpl(
            localSource = localDataSource,
            remoteSource = remoteDataSource,
            sessionInterceptor = sessionInterceptor
        )
    }

    @Provides
    @Singleton
    fun quotesRepository(
        localDataSource: QuotesDataSource.Local,
        remoteDataSource: QuotesDataSource.Remote
    ): QuotesRepository {
        return QuotesRepositoryImpl(
            localSource = localDataSource,
            remoteSource = remoteDataSource
        )
    }
}

@Module
class DataSourceLocalModule {
    @Provides
    @Singleton
    fun accountLocalService(localPreferences: PersistedPreferences): AccountDataSource.Local {
        return AccountLocalDataSource(persistedPreferences = localPreferences)
    }

    @Provides
    @Singleton
    fun quotesLocalService(): QuotesDataSource.Local {
        return QuotesLocalDataSource()
    }
}

@Module
class DataSourceRemoteModule {
    @Provides
    @Singleton
    fun remoteAccountDataSource(accountRemoteService: AccountRemoteService)
            : AccountDataSource.Remote {
        return AccountRemoteDataSource(accountRemoteService)
    }

    @Provides
    @Singleton
    fun remoteQuotesDataSource(quotesRemoteService: QuotesRemoteService)
            : QuotesDataSource.Remote {
        return QuotesRemoteDataSource(quotesRemoteService)
    }
}

@Module
class NetworkServiceModule {
    companion object {
        private const val BASE_URL = "https://favqs.com/api/"
    }

    private val headersInterceptor: HeadersInterceptor = HeadersInterceptor()

    @Provides
    @Singleton
    fun client(): Retrofit {
        // TODO - set logging level interception according to build config
        val loggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(headersInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun headerCallsInterceptor(): SessionInterceptor {
        return headersInterceptor
    }
}

@Module
class ServiceRemoteModule {
    @Provides
    @Singleton
    fun accountRemoteService(client: Retrofit): AccountRemoteService {
        return client.create(AccountRemoteService::class.java)
    }

    @Provides
    @Singleton
    fun quotesRemoteService(client: Retrofit): QuotesRemoteService {
        return client.create(QuotesRemoteService::class.java)
    }
}

@Module
class PersistedPreferencesModule {
    @Provides
    @Singleton
    fun persistedPreferences(context: Context): PersistedPreferences {
        return LocalPreferences(context = context)
    }
}

@Module
class ContextModule(private val app: Application) {
    @Provides
    @Singleton
    fun provideContext(): Context = app.applicationContext
}
