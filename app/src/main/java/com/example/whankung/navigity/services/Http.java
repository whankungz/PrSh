package com.example.whankung.navigity.services;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.provider.SyncStateContract;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.StringDef;
import android.support.annotation.StyleRes;
import android.support.compat.BuildConfig;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.Display;

import com.example.whankung.navigity.MainActivity;
import com.example.whankung.navigity.adapter.AppState;
import com.example.whankung.navigity.services.Article.AInterface;
import com.example.whankung.navigity.services.Disease.DInterface;
import com.example.whankung.navigity.services.Food.FInterface;
import com.example.whankung.navigity.services.Herb.HInterface;
import com.example.whankung.navigity.services.Herb.HimgInterface;
import com.example.whankung.navigity.services.Herb.HreInterface;
import com.example.whankung.navigity.services.InfoG.InfoInterface;
import com.example.whankung.navigity.services.Office.OfInterface;
import com.facebook.stetho.DumperPluginsProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.facebook.stetho.okhttp3.StethoInterceptor;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;


import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.framed.Http2;
import okhttp3.internal.http.HttpMethod;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;


import static com.example.whankung.navigity.SearchDisease.BASE_URL;
import static okhttp3.Authenticator.NONE;

/**
 * Created by Whankung on 21/2/2560.
 */

public class Http  {
    private static Http instance;
    DInterface disease;
    HInterface herb;
    HreInterface herbre;
    HimgInterface herbimg;
    AInterface article;
    FInterface food;
    InfoInterface info;
    OfInterface office;
private Retrofit retrofit;

    private static final String CACHE_CONTROL = "Cache-Control";

    public Http() {
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();

//        OkHttpClient client = new OkHttpClient
//                .Builder()
//                .cache(new okhttp3.Cache(getContext().getCacheDir(), 10 * 1024 * 1024)) // 10 MB
//                .addInterceptor(new Interceptor() {
//                    @Override public okhttp3.Response intercept(Chain chain) throws IOException {
//                        Request request = chain.request();
//                        if (AppState.getSingleInstance().isNetworkAvailable(getActivity())) {
//                            request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
//                        } else {
//                            request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
//                        }
//                        return chain.proceed(request);
//                    }
//                })
//                .build();
//
        OkHttpClient Client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                // Enable response caching
                //.addNetworkInterceptor(new ResponseCacheInterceptor())
//                .addInterceptor(new OfflineResponseCacheInterceptor() {
//                    @Override
//                    public AssetManager getAssets() {
//                        return null;
//                    }
//
//                    @Override
//                    public Resources getResources() {
//                        return null;
//                    }
//
//                    @Override
//                    public PackageManager getPackageManager() {
//                        return null;
//                    }
//
//                    @Override
//                    public ContentResolver getContentResolver() {
//                        return null;
//                    }
//
//                    @Override
//                    public Looper getMainLooper() {
//                        return null;
//                    }
//
//                    @Override
//                    public Context getApplicationContext() {
//                        return null;
//                    }
//
//                    @Override
//                    public void setTheme(@StyleRes int resid) {
//
//                    }
//
//                    @Override
//                    public Resources.Theme getTheme() {
//                        return null;
//                    }
//
//                    @Override
//                    public ClassLoader getClassLoader() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getPackageName() {
//                        return null;
//                    }
//
//                    @Override
//                    public ApplicationInfo getApplicationInfo() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getPackageResourcePath() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getPackageCodePath() {
//                        return null;
//                    }
//
//                    @Override
//                    public SharedPreferences getSharedPreferences(String name, int mode) {
//                        return null;
//                    }
//
//                    @Override
//                    public boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean deleteSharedPreferences(String name) {
//                        return false;
//                    }
//
//                    @Override
//                    public FileInputStream openFileInput(String name) throws FileNotFoundException {
//                        return null;
//                    }
//
//                    @Override
//                    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
//                        return null;
//                    }
//
//                    @Override
//                    public boolean deleteFile(String name) {
//                        return false;
//                    }
//
//                    @Override
//                    public File getFileStreamPath(String name) {
//                        return null;
//                    }
//
//                    @Override
//                    public File getDataDir() {
//                        return null;
//                    }
//
//                    @Override
//                    public File getFilesDir() {
//                        return null;
//                    }
//
//                    @Override
//                    public File getNoBackupFilesDir() {
//                        return null;
//                    }
//
//                    @Nullable
//                    @Override
//                    public File getExternalFilesDir(@Nullable String type) {
//                        return null;
//                    }
//
//                    @Override
//                    public File[] getExternalFilesDirs(String type) {
//                        return new File[0];
//                    }
//
//                    @Override
//                    public File getObbDir() {
//                        return null;
//                    }
//
//                    @Override
//                    public File[] getObbDirs() {
//                        return new File[0];
//                    }
//
//                    @Override
//                    public File getCacheDir() {
//                        return null;
//                    }
//
//                    @Override
//                    public File getCodeCacheDir() {
//                        return null;
//                    }
//
//                    @Nullable
//                    @Override
//                    public File getExternalCacheDir() {
//                        return null;
//                    }
//
//                    @Override
//                    public File[] getExternalCacheDirs() {
//                        return new File[0];
//                    }
//
//                    @Override
//                    public File[] getExternalMediaDirs() {
//                        return new File[0];
//                    }
//
//                    @Override
//                    public String[] fileList() {
//                        return new String[0];
//                    }
//
//                    @Override
//                    public File getDir(String name, int mode) {
//                        return null;
//                    }
//
//                    @Override
//                    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
//                        return null;
//                    }
//
//                    @Override
//                    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, @Nullable DatabaseErrorHandler errorHandler) {
//                        return null;
//                    }
//
//                    @Override
//                    public boolean moveDatabaseFrom(Context sourceContext, String name) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean deleteDatabase(String name) {
//                        return false;
//                    }
//
//                    @Override
//                    public File getDatabasePath(String name) {
//                        return null;
//                    }
//
//                    @Override
//                    public String[] databaseList() {
//                        return new String[0];
//                    }
//
//                    @Override
//                    public Drawable getWallpaper() {
//                        return null;
//                    }
//
//                    @Override
//                    public Drawable peekWallpaper() {
//                        return null;
//                    }
//
//                    @Override
//                    public int getWallpaperDesiredMinimumWidth() {
//                        return 0;
//                    }
//
//                    @Override
//                    public int getWallpaperDesiredMinimumHeight() {
//                        return 0;
//                    }
//
//                    @Override
//                    public void setWallpaper(Bitmap bitmap) throws IOException {
//
//                    }
//
//                    @Override
//                    public void setWallpaper(InputStream data) throws IOException {
//
//                    }
//
//                    @Override
//                    public void clearWallpaper() throws IOException {
//
//                    }
//
//                    @Override
//                    public void startActivity(@RequiresPermission Intent intent) {
//
//                    }
//
//                    @Override
//                    public void startActivity(@RequiresPermission Intent intent, @Nullable Bundle options) {
//
//                    }
//
//                    @Override
//                    public void startActivities(@RequiresPermission Intent[] intents) {
//
//                    }
//
//                    @Override
//                    public void startActivities(@RequiresPermission Intent[] intents, Bundle options) {
//
//                    }
//
//                    @Override
//                    public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
//
//                    }
//
//                    @Override
//                    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
//
//                    }
//
//                    @Override
//                    public void sendBroadcast(@RequiresPermission Intent intent) {
//
//                    }
//
//                    @Override
//                    public void sendBroadcast(@RequiresPermission Intent intent, @Nullable String receiverPermission) {
//
//                    }
//
//                    @Override
//                    public void sendOrderedBroadcast(@RequiresPermission Intent intent, @Nullable String receiverPermission) {
//
//                    }
//
//                    @Override
//                    public void sendOrderedBroadcast(@RequiresPermission @NonNull Intent intent, @Nullable String receiverPermission, @Nullable BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {
//
//                    }
//
//                    @Override
//                    public void sendBroadcastAsUser(@RequiresPermission Intent intent, UserHandle user) {
//
//                    }
//
//                    @Override
//                    public void sendBroadcastAsUser(@RequiresPermission Intent intent, UserHandle user, @Nullable String receiverPermission) {
//
//                    }
//
//                    @Override
//                    public void sendOrderedBroadcastAsUser(@RequiresPermission Intent intent, UserHandle user, @Nullable String receiverPermission, BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {
//
//                    }
//
//                    @Override
//                    public void sendStickyBroadcast(@RequiresPermission Intent intent) {
//
//                    }
//
//                    @Override
//                    public void sendStickyOrderedBroadcast(@RequiresPermission Intent intent, BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {
//
//                    }
//
//                    @Override
//                    public void removeStickyBroadcast(@RequiresPermission Intent intent) {
//
//                    }
//
//                    @Override
//                    public void sendStickyBroadcastAsUser(@RequiresPermission Intent intent, UserHandle user) {
//
//                    }
//
//                    @Override
//                    public void sendStickyOrderedBroadcastAsUser(@RequiresPermission Intent intent, UserHandle user, BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {
//
//                    }
//
//                    @Override
//                    public void removeStickyBroadcastAsUser(@RequiresPermission Intent intent, UserHandle user) {
//
//                    }
//
//                    @Nullable
//                    @Override
//                    public Intent registerReceiver(@Nullable BroadcastReceiver receiver, IntentFilter filter) {
//                        return null;
//                    }
//
//                    @Nullable
//                    @Override
//                    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler) {
//                        return null;
//                    }
//
//                    @Override
//                    public void unregisterReceiver(BroadcastReceiver receiver) {
//
//                    }
//
//                    @Nullable
//                    @Override
//                    public ComponentName startService(Intent service) {
//                        return null;
//                    }
//
//                    @Override
//                    public boolean stopService(Intent service) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean bindService(@RequiresPermission Intent service, @NonNull ServiceConnection conn, int flags) {
//                        return false;
//                    }
//
//                    @Override
//                    public void unbindService(@NonNull ServiceConnection conn) {
//
//                    }
//
//                    @Override
//                    public boolean startInstrumentation(@NonNull ComponentName className, @Nullable String profileFile, @Nullable Bundle arguments) {
//                        return false;
//                    }
//
//                    @Override
//                    public Object getSystemService(@NonNull String name) {
//                        return null;
//                    }
//
//                    @Override
//                    public String getSystemServiceName(Class<?> serviceClass) {
//                        return null;
//                    }
//
//                    @Override
//                    public int checkPermission(@NonNull String permission, int pid, int uid) {
//                        return 0;
//                    }
//
//                    @Override
//                    public int checkCallingPermission(@NonNull String permission) {
//                        return 0;
//                    }
//
//                    @Override
//                    public int checkCallingOrSelfPermission(@NonNull String permission) {
//                        return 0;
//                    }
//
//                    @Override
//                    public int checkSelfPermission(@NonNull String permission) {
//                        return 0;
//                    }
//
//                    @Override
//                    public void enforcePermission(@NonNull String permission, int pid, int uid, @Nullable String message) {
//
//                    }
//
//                    @Override
//                    public void enforceCallingPermission(@NonNull String permission, @Nullable String message) {
//
//                    }
//
//                    @Override
//                    public void enforceCallingOrSelfPermission(@NonNull String permission, @Nullable String message) {
//
//                    }
//
//                    @Override
//                    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
//
//                    }
//
//                    @Override
//                    public void revokeUriPermission(Uri uri, int modeFlags) {
//
//                    }
//
//                    @Override
//                    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
//                        return 0;
//                    }
//
//                    @Override
//                    public int checkCallingUriPermission(Uri uri, int modeFlags) {
//                        return 0;
//                    }
//
//                    @Override
//                    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
//                        return 0;
//                    }
//
//                    @Override
//                    public int checkUriPermission(@Nullable Uri uri, @Nullable String readPermission, @Nullable String writePermission, int pid, int uid, int modeFlags) {
//                        return 0;
//                    }
//
//                    @Override
//                    public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
//
//                    }
//
//                    @Override
//                    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
//
//                    }
//
//                    @Override
//                    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
//
//                    }
//
//                    @Override
//                    public void enforceUriPermission(@Nullable Uri uri, @Nullable String readPermission, @Nullable String writePermission, int pid, int uid, int modeFlags, @Nullable String message) {
//
//                    }
//
//                    @Override
//                    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
//                        return null;
//                    }
//
//                    @Override
//                    public Context createConfigurationContext(@NonNull Configuration overrideConfiguration) {
//                        return null;
//                    }
//
//                    @Override
//                    public Context createDisplayContext(@NonNull Display display) {
//                        return null;
//                    }
//
//                    @Override
//                    public Context createDeviceProtectedStorageContext() {
//                        return null;
//                    }
//
//                    @Override
//                    public boolean isDeviceProtectedStorage() {
//                        return false;
//                    }
//                })
                // Set the cache location and size (5 MB)
               // .cache(provideCache())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(Client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        disease = retrofit.create(DInterface.class);
        herb = retrofit.create(HInterface.class);
        herbimg = retrofit.create(HimgInterface.class);
        herbre = retrofit.create(HreInterface.class);
        article = retrofit.create(AInterface.class);
        food = retrofit.create(FInterface.class);
        info = retrofit.create(InfoInterface.class);
        office = retrofit.create(OfInterface.class);
    }
    private static class ResponseCacheInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            okhttp3.Response originalResponse = chain.proceed(chain.request());
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + 60)
                    .build();
        }
    }
    public static abstract class OfflineResponseCacheInterceptor extends Context implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (AppState.getSingleInstance().isNetworkAvailable(this)) {
                request = request.newBuilder()
                        .url(BASE_URL)
                        .header("Cache-Control",
                                "public, only-if-cached, max-stale=" + 2419200)
                        .build();
            }else {
                chain.proceed(request);
            }
            return chain.proceed(request);

        }
    }

    public OkHttpClient provideOkHttpClient() {

        return new OkHttpClient.Builder()
                 .cache( provideCache() )
                //.cache(new okhttp3.Cache(AdeptAndroid.getInstance().getCacheDir(), 10 * 1024 * 1024)) // 10 MB
                //.addInterceptor(provideHttpLoggingInterceptor())
               // .addInterceptor(provideOfflineCacheInterceptor())
              //  .addInterceptor(provideCacheInterceptor())
              //  .addNetworkInterceptor( provideCacheInterceptor() )
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        if (AdeptAndroid.hasNetwork()) {
                            request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
                        } else {
                            request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
                        }
                        return chain.proceed(request);
                    }
                })
                .build();



    }

    private static Cache provideCache() {
        Cache cache = null;
        try {
            cache = new Cache(new File(AdeptAndroid.getInstance().getCacheDir(), "http-cache"),
                    10 * 1024 * 1024); // 10 MB
        } catch (Exception e) {

        }
        return cache;
    }

    private static HttpLoggingInterceptor provideHttpLoggingInterceptor ()
    {
        HttpLoggingInterceptor httpLoggingInterceptor =
                new HttpLoggingInterceptor( new HttpLoggingInterceptor.Logger()
                {
                    @Override
                    public void log (String message)
                    {
                      //  Timber.d( message );
                    }
                } );
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        //httpLoggingInterceptor.setLevel( BuildConfig.DEBUG ? HEADERS : NONE );
        return httpLoggingInterceptor;
    }

    public static Interceptor provideCacheInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());

                // re-write response header to force use of cache
                CacheControl cacheControl = new CacheControl.Builder()
                        .maxAge(100, TimeUnit.MINUTES)
                        .build();

                return response.newBuilder()
                        .header(CACHE_CONTROL, cacheControl.toString())
                        .build();
            }
        };
    }

    public static Interceptor provideOfflineCacheInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                if (!AdeptAndroid.hasNetwork()) {
                    CacheControl cacheControl = new CacheControl.Builder()
                            .maxStale(7, TimeUnit.DAYS)
                            .build();

                    request = request.newBuilder()
                            .cacheControl(cacheControl)
                            .build();
                }

                return chain.proceed(request);
            }
        };
    }

    public static Http getInstance() {

        return new Http();
    }


    public InfoInterface getInfo() {
        return info;
    }

    public OfInterface getOffice() {
        return office;
    }

    public FInterface getFood() {
        return food;
    }

    public DInterface getDisease() {
        return disease;
    }

    public HInterface getHerb() {
        return herb;
    }

    public HreInterface getHerbre() {
        return herbre;
    }

    public HimgInterface getHerbimg() {
        return herbimg;
    }

    public AInterface getArticle() {
        return article;
    }
}
