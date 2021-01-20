//package com.zhewen.eyepetizer_common.apitemp
//
//import com.google.android.play.core.internal.k
//import okhttp3.OkHttpClient
//import org.gradle.internal.impldep.com.fasterxml.jackson.databind.PropertyNamingStrategy
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//
//object ApiManager {
//    var accountApi: AccountApi? = null
//    var adApi: AdApi? = null
//    var amapApi: AmapApi? = null
//    var authorAccountApi: AuthorAccountApi? = null
//    var authApi: AuthApi? = null
//    val BASE_AUTHOR_ACCOUNT_URL: String? = null
//    val BASE_NORMAL_ACCOUNT_URL: String? = null
//    val baseUrl = if (i0.D()) ONLINE_BASE_URL else STAGING_BASE_URL
//    var brandApi: BrandApi? = null
//    var CARD_API: CardAPI? = null
//    var chatApi: ChatApi? = null
//    var commonApi: CommonApi? = null
//    const val DEFAULT_TIMEOUT: Long = 60000
//    var ePassApi: EPassApi? = null
//    var globalCommentApi: GlobalCommentApi? = null
//    var globalShareApi: GlobalShareApi? = null
//    var HEADERS: Headers? = null
//    var LAST_MESSAGE_TIME: Long = 0
//    var liveApi: LiveAPI? = null
//    var LIVE_ROOM_API: LiveRoomApi? = null
//    var medalApi: MedalApi? = null
//    var NEW_SEARCH_API: NewSearchApi? = null
//    var normalAccountApi: NormalAccountApi? = null
//    const val ONLINE_BASE_AUTHOR_ACCOUNT_URL = "https://account.kaiyanapp.com/"
//    const val ONLINE_BASE_NORMAL_ACCOUNT_URL = "https://account.kaiyanapp.com/"
//    const val ONLINE_BASE_URL = "https://baobab.kaiyanapp.com/"
//    var pgcApi: PgcApi? = null
//    var publishApi: PublishApi? = null
//    var pushApi: PushApi? = null
//    var searchApi: SearchApi? = null
//    var shieldApi: ShieldApi? = null
//    const val STAGING_BASE_AUTHOR_ACCOUNT_URL = "https://open-test.kaiyanapp.com/"
//    const val STAGING_BASE_NORMAL_ACCOUNT_URL = "https://account-test.kaiyanapp.com/"
//    const val STAGING_BASE_URL = "http://staging.kaiyanapp.com/"
//    var tabApi: TabApi? = null
//    var tagApi: TagApi? = null
//    val TFEYE_BASE_URL = if (i0.D()) TFEYE_OLINE_BASE_URL else TFEYE_STAGING_BASE_URL
//    const val TFEYE_OLINE_BASE_URL = "http://api.eyepetizer.net/"
//    const val TFEYE_STAGING_BASE_URL = "https://api-staging.eyepetizer.net/"
//    const val TF_BASE_URL = "http://api.thefair.net.cn/"
//    const val TF_OLINE_BASE_URL = "http://api.thefair.net.cn/"
//    const val TF_STAGING_BASE_URL = "http://api.thefair.net.cn/"
//    var topicApi: TopicApi? = null
//    var ugcApi: UgcApi? = null
//    var urlApi: UrlApi? = null
//    var versionApi: VersionApi? = null
//    var videoApi: VideoApi? = null
//    var normalClient: OkHttpClient? = null
//    var tfEyeClient: OkHttpClient =
//        Builder().addInterceptor(TFHttpInterceptor()).addInterceptor(MessageInterceptor())
//            .hostnameVerifier(j1.a).connectTimeout(
//                DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS
//            ).writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS).readTimeout(
//                DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS
//            ).build()
//    val cardApi: CardAPI?
//        get() = CARD_API
//    var headers: Headers?
//        get() = HEADERS
//        set(headers) {
//            HEADERS = headers
//        }
//    val liveRoomApi: LiveRoomApi?
//        get() = LIVE_ROOM_API
//    val newSearchApi: NewSearchApi?
//        get() = NEW_SEARCH_API
//
//    init {
//        val D: Boolean = i0.D()
//        var str = "https://account.kaiyanapp.com/"
//        BASE_NORMAL_ACCOUNT_URL = if (i0.D()) str else STAGING_BASE_NORMAL_ACCOUNT_URL
//        if (!i0.D()) {
//            str = STAGING_BASE_AUTHOR_ACCOUNT_URL
//        }
//        BASE_AUTHOR_ACCOUNT_URL = str
//        SerializeConfig.getGlobalInstance().propertyNamingStrategy =
//            org.gradle.internal.impldep.com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCase
//        val readTimeout: Builder =
//            Builder().addInterceptor(BaseInterceptor()).hostnameVerifier(j1.a).connectTimeout(
//                DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS
//            ).writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS).readTimeout(
//                DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS
//            )
//        if (GlobalConfig.isDebug()) {
//            val httpLoggingInterceptor: Interceptor = HttpLoggingInterceptor()
//            httpLoggingInterceptor.setLevel(Level.BODY)
//            readTimeout.addInterceptor(httpLoggingInterceptor)
//            readTimeout.addNetworkInterceptor(a())
//        }
//        normalClient = readTimeout.build()
//        val build = Retrofit.Builder().baseUrl(baseUrl).client(normalClient)
//            .addConverterFactory(GsonConverterFactory.create(CustomGson.getGson()))
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build()
//        val client = Retrofit.Builder().baseUrl(TF_BASE_URL).client(
//            Builder().addInterceptor(TFHttpInterceptor()).hostnameVerifier(j1.a).connectTimeout(
//                DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS
//            ).writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS).readTimeout(
//                DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS
//            ).build()
//        )
//        val kVar = k()
//        kVar.c(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//        client.addConverterFactory(GsonConverterFactory.create(kVar.a()))
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build()
//        val client2 = Retrofit.Builder().baseUrl(TFEYE_BASE_URL).client(tfEyeClient)
//        val kVar2 = k()
//        kVar2.c(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//        val build2 = client2.addConverterFactory(GsonConverterFactory.create(kVar2.a()))
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build()
//        shieldApi = build.create(ShieldApi::class.java) as ShieldApi
//        urlApi = build.create(UrlApi::class.java) as UrlApi
//        pgcApi = build.create(PgcApi::class.java) as PgcApi
//        accountApi = build.create(AccountApi::class.java) as AccountApi
//        videoApi = build.create(VideoApi::class.java) as VideoApi
//        tabApi = build.create(TabApi::class.java) as TabApi
//        ugcApi = build.create(UgcApi::class.java) as UgcApi
//        tagApi = build.create(TagApi::class.java) as TagApi
//        publishApi = build.create(PublishApi::class.java) as PublishApi
//        commonApi = build.create(CommonApi::class.java) as CommonApi
//        amapApi = build.create(AmapApi::class.java) as AmapApi
//        searchApi = build.create(SearchApi::class.java) as SearchApi
//        medalApi = build.create(MedalApi::class.java) as MedalApi
//        topicApi = build.create(TopicApi::class.java) as TopicApi
//        chatApi = build.create(ChatApi::class.java) as ChatApi
//        adApi = build.create(AdApi::class.java) as AdApi
//        LIVE_ROOM_API = build2.create(LiveRoomApi::class.java) as LiveRoomApi?
//        authApi = build2.create(AuthApi::class.java) as AuthApi
//        CARD_API = build2.create(CardAPI::class.java) as CardAPI?
//        liveApi = build2.create(LiveAPI::class.java) as LiveAPI
//        versionApi = build2.create(VersionApi::class.java) as VersionApi
//        NEW_SEARCH_API = build2.create(NewSearchApi::class.java) as NewSearchApi?
//        pushApi = build2.create(PushApi::class.java) as PushApi
//        brandApi = build2.create(BrandApi::class.java) as BrandApi
//        globalCommentApi = build2.create(GlobalCommentApi::class.java) as GlobalCommentApi
//        globalShareApi = build2.create(GlobalShareApi::class.java) as GlobalShareApi
//        ePassApi = build2.create(EPassApi::class.java) as EPassApi
//        normalAccountApi =
//            Retrofit.Builder().baseUrl(BASE_NORMAL_ACCOUNT_URL).client(readTimeout.build())
//                .addConverterFactory(GsonConverterFactory.create(CustomGson.getGson()))
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build().create(
//                    NormalAccountApi::class.java
//                ) as NormalAccountApi
//        authorAccountApi =
//            Retrofit.Builder().baseUrl(BASE_AUTHOR_ACCOUNT_URL).client(readTimeout.build())
//                .addConverterFactory(GsonConverterFactory.create(CustomGson.getGson()))
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build().create(
//                    AuthorAccountApi::class.java
//                ) as AuthorAccountApi
//    }
//}