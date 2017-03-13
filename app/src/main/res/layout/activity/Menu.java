package com.example.whankung.socialherb.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.fragment.Article.MainArticle;
import com.example.whankung.socialherb.fragment.Disease.MainDisease;
import com.example.whankung.socialherb.fragment.Favorite.MainFavorite;
import com.example.whankung.socialherb.fragment.Herb.MainHerb;
import com.example.whankung.socialherb.view.Singleton;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

/**
 * Created by Whankung on 16/1/2560.
 */

public class Menu extends AppCompatActivity {
//    implements GoogleApiClient.OnConnectionFailedListener,View.OnClickListener
    private Typeface font;
    private TextView tv;

    private Drawer result = null;
    com.example.whankung.socialherb.activity.SessionManagement session;


    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    // nav drawer title
    private CharSequence mDrawerTitle;
    // used to store app title
    private CharSequence mTitle;
    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private ArrayList<com.example.whankung.socialherb.activity.NavDrawerItem> navDrawerItems;
    private com.example.whankung.socialherb.activity.NavDrawerListAdapter adapter;


    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;
    private TextView mStatusTextView;
    private GoogleApiClient mGoogleApiClient;
    private SignInButton signInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        setView();
        setBottomBar();
      //  setMenu();
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//        mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
//                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
//                .build();


    }


//    private void setMenu() {
//       // setContentView(R.layout.menu2);
//        mTitle = mDrawerTitle = getTitle();
//
//        // load slide menu items
//        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
//
//        // nav drawer icons from resources
//        navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);
//
//
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerList = (ListView) findViewById(R.id.drawer);
//
//        navDrawerItems = new ArrayList<NavDrawerItem>();
//
//        // adding nav drawer items to array
//        // Home
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0]));
//        navMenuIcons.getResourceId(0,0);
//
//        // Find People
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1]));
//        // Photos
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2]));
//        // Communities, Will add a counter here
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3]));
//        // Pages
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4]));
//        // What's hot, We  will add a counter here
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[5]));
//
//
//        // Recycle the typed array
//        navMenuIcons.recycle();
//
//        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
//
//        // setting the nav drawer list adapter
//        adapter = new NavDrawerListAdapter(getApplicationContext(),
//                navDrawerItems);
//        mDrawerList.setAdapter(adapter);
//
//        // enabling action bar app icon and behaving it as toggle button
//        assert getSupportActionBar()!=null;
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//
//
//
//
//        mDrawerToggle = new ActionBarDrawerToggle (this, mDrawerLayout,
//
//                // R.drawable.ic_drawer, //nav menu toggle icon
//                R.string.app_name, // nav drawer open - description for accessibility
//                R.string.app_name // nav drawer close - description for accessibility
//        ) {
//            public void onDrawerClosed(View view) {
//                getSupportActionBar().setTitle(mTitle);
//                // calling onPrepareOptionsMenu() to show action bar icons
//getSupportActionBar().show();
//                invalidateOptionsMenu();
//
//            }
//
//            public void onDrawerOpened(View drawerView) {
//                getSupportActionBar().setTitle(mDrawerTitle);
//                // calling onPrepareOptionsMenu() to hide action bar icons
//                invalidateOptionsMenu();
//
//                getSupportActionBar().hide();
//            }
//        };
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
////
////        if (savedInstanceState == null) {
////            // on first time display view for first nav item
////            displayView(0);
////        }
//    }

//    /**
//     * Slide menu item click listener
//     */
//    private class SlideMenuClickListener implements
//            ListView.OnItemClickListener {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position,
//                                long id) {
//            // display view for selected nav drawer item
//            displayView(position);
//        }
//
//
//    }

////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        getMenuInflater().inflate(R.menu.menu_main, menu);
////        return true;
////    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // toggle nav drawer on selecting action bar app icon/title
//        if (mDrawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        // Handle action bar actions click
//        switch (item.getItemId()) {
//            case R.id.action_login:
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        // Sync the toggle state after onRestoreInstanceState has occurred.
//        mDrawerToggle.syncState();
//
//
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        mDrawerToggle.onConfigurationChanged(newConfig);
//    }
//
//    /***
//     * Called when invalidateOptionsMenu() is triggered
//     */
//
////    public boolean onPrepareOptionsMenu(Menu menu) {
////        // if nav drawer is opened, hide the action items
////        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
////       menu.findItem(R.id.action_login).setVisible(!drawerOpen);
////        return super.onPrepareOptionsMenu((android.view.Menu) menu);
////    }
//
//    /**
//     * Diplaying fragment view for selected nav drawer list item
//     */
//    private void displayView(int position) {
//        // update the main content by replacing fragments
//        Fragment fragment = null;
//        switch (position) {
//            case 0:
//                fragment = new LoginFragment();
//
//                break;
//            case 1:
//                fragment = new StartApp();
//                break;
//            case 2:
//                fragment = new InfoFragment();
//                break;
//            case 3:
//                fragment = new FoodFragment();
//                break;
//            case 4:
//                fragment = new ShareFragment();
//                break;
//            case 5:
//                fragment = new ContectFragment();
//                break;
//
//            default:
//                break;
//        }
//
//
//
//        if (fragment != null) {
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction()
//                    .replace(R.id.container, fragment).commit();
//            getSupportActionBar().hide();
//
//            // update selected item and title, then close the drawer
//            mDrawerList.setItemChecked(position, true);
//            mDrawerList.setSelection(position);
//            setTitle(navMenuTitles[position]);
//            mDrawerLayout.closeDrawer(mDrawerList);
//        } else {
//            // error in creating fragment
//            Log.e("MainActivity", "Error in creating fragment");
//    }
//   }



    private void setView() {
//        mStatusTextView = (TextView) findViewById(R.id.status);
//        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
//        signInButton.setSize(SignInButton.SIZE_STANDARD);
//        findViewById(R.id.sign_in_button).setOnClickListener(this);

        session = new com.example.whankung.socialherb.activity.SessionManagement(getApplicationContext());
        tv = (TextView) findViewById(R.id.toolbar_title);

        Singleton.getInstance().setFirstOpenApp(true);

//                เปลี่ยน font
        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        //ประกาศตัวปุ่มย้อนกลับของเรา ผูกตัวแปรไว้
//        ImageView img = (ImageView) findViewById(R.id.action);
//        img.setVisibility(View.VISIBLE);
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //กลับไปยังหน้าเลือก ถาคของเรา
//                Intent intent = new Intent(getApplicationContext(), Login.class);
//                startActivity(intent);
//
//            }
//        });


        // Handle toolbar
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.drawer_item_menu_drawer);


//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setHomeButtonEnabled(true);
//        getActionBar().setHomeAsUpIndicator(R.d);


//....................    profile
//        ProfileDrawerItem profileMain = new ProfileDrawerItem();
//        AccountHeader accountHeader = new AccountHeaderBuilder()
//                .withActivity(this)
//                .addProfiles(
//                        profileMain.withName("login")
//                )
//
//
//        .withTextColor(getResources().getColor(R.color.md_dark_appbar))
//
//                .withNameTypeface(Typeface.createFromAsset(getAssets(), "tmedium.ttf"))
//                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
//                    @Override
//                    public boolean onProfileChanged(View view, IProfile iProfile, boolean b) {
//                        if (b == true) {
//                            Intent intent = new Intent(getApplicationContext(), Login.class);
//                            startActivity(intent);
//                        } else {
//
//                        }
//                        return false;
//                    }
//                })
//                .withProfileImagesClickable(true)
//                .withSelectionListEnabled(false)
//                .build();
//
//        session.checkLogin();
//
//        // get user data from session
//        HashMap<String, String> user = session.getUserDetails();
//
//        // name
//        String name = user.get(SessionManagement.KEY_NAME);
//
//        // email
//        String email = user.get(SessionManagement.KEY_EMAIL);
//        // displaying user data
//        accountHeader.equals(Html.fromHtml("Name: <b>" + name + "</b>"));
//
//        accountHeader.equals(Html.fromHtml("Email: <b>" + email + "</b>"));


        final Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
//                .withAccountHeader(accountHeader)
                .withCloseOnClick(true)
                .withSliderBackgroundColorRes(R.color.md_light_primary_text)

                .addDrawerItems(
//                        new PrimaryDrawerItem()
//                                .withIcon(FontAwesome.Icon.faw_sign_in)
//                                .withName(String.valueOf(Html.fromHtml("ล็อกอิน")))
//                                .withIconColor(getResources().getColor(R.color.md_grey_100))
//                                .withIdentifier(0)
//                                .withTextColorRes(R.color.md_grey_100)
//                                .withSelectable(false),
                        new PrimaryDrawerItem()
                                .withIcon(FontAwesome.Icon.faw_home)
                                .withName(String.valueOf(Html.fromHtml("หน้าแรก")))
                                .withIconColor(getResources().getColor(R.color.md_grey_100))
                                .withIdentifier(0)
                                .withTextColorRes(R.color.md_grey_100)
                                .withSelectable(false),

                        new PrimaryDrawerItem()
                                .withIcon(FontAwesome.Icon.faw_list_alt)
                                .withName("Infographic")
                                .withIconColor(getResources().getColor(R.color.md_grey_100))
                                .withIdentifier(0)
                                .withTextColorRes(R.color.md_grey_100)
                                .withSelectable(false),
                        new PrimaryDrawerItem()
                                .withIcon(FontAwesome.Icon.faw_spoon)
                                .withName("อาหารเพื่อสุขภาพ")
                                .withIconColor(getResources().getColor(R.color.md_grey_100))
                                .withIdentifier(0)
                                .withTextColorRes(R.color.md_grey_100)
                                .withSelectable(false),
                        new PrimaryDrawerItem()
                                .withIcon(FontAwesome.Icon.faw_university)
                                .withName("หน่วยงานที่เกี่ยวข้อง")
                                .withIconColor(getResources().getColor(R.color.md_grey_100))
                                .withIdentifier(0)
                                .withTextColorRes(R.color.md_grey_100)
                                .withSelectable(false),

                        new PrimaryDrawerItem()
                                .withIcon(FontAwesome.Icon.faw_share)
                                .withName("แชร์")
                                .withIconColor(getResources().getColor(R.color.md_grey_100))
                                .withIdentifier(0)
                                .withTextColorRes(R.color.md_grey_100)
                                .withSelectable(false),


                        new PrimaryDrawerItem()
                                .withSelectable(false)
                                .withIconColor(getResources().getColor(R.color.md_grey_100))
                                .withTextColorRes(R.color.md_grey_100)
                                .withIdentifier(3),
                        new PrimaryDrawerItem()
                                .withSelectable(false)
                                .withIconColor(getResources().getColor(R.color.md_grey_100))
                                .withTextColorRes(R.color.md_grey_100)
                                .withIdentifier(3),
                        new PrimaryDrawerItem()
                                .withSelectable(false)
                                .withIconColor(getResources().getColor(R.color.md_grey_100))
                                .withTextColorRes(R.color.md_grey_100)
                                .withIdentifier(3),


                        new DividerDrawerItem(),






                        new PrimaryDrawerItem()
                                .withIcon(FontAwesome.Icon.faw_user)
                                .withName("Invite")
                                .withSelectable(false)
                                .withIconColor(getResources().getColor(R.color.md_grey_100))
                                .withTextColorRes(R.color.md_grey_100)
                                .withIdentifier(3)
//                        ,
//                        new PrimaryDrawerItem()
//                                .withIcon(FontAwesome.Icon.faw_sign_out)
//                                .withName("ออกจากระบบ")
//                                .withSelectable(false)
//                                .withIconColor(getResources().getColor(R.color.md_grey_100))
//                                .withTextColorRes(R.color.md_grey_100)
//                                .withIdentifier(4)
                )
                .withSelectedItem(-1)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                                   @Override
                                                   public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                                       if (drawerItem instanceof Nameable) {
                                                      //     Toast.makeText(Menu.this, ((Nameable) drawerItem).getName().getText(Menu.this), Toast.LENGTH_SHORT).show();
                                                       }
                                                       FragmentManager manager = getSupportFragmentManager();
                                                       FragmentTransaction transaction = manager.beginTransaction();
                                                       switch (position) {
//                                                           case 0:
//                                                               Intent intent = new Intent(getApplicationContext(), Login.class);
//                                                               startActivity(intent);
//
//                                                               break;
                                                           case 0:

                                                              Intent intent = new Intent(getApplicationContext(), com.example.whankung.socialherb.activity.StartApp2.class);
                                                               startActivity(intent);
                                                               break;
                                                           case 1:
                                                               tv.setText("Infoghaphic");
                                                               intent = new Intent(getApplicationContext(), com.example.whankung.socialherb.activity.MainInfo.class);
                                                               startActivity(intent);

                                                               break;
                                                           case 2:
                                                               tv.setText("อาหารเพื่อสุขภาพ");
                                                               session = new com.example.whankung.socialherb.activity.SessionManagement(getApplicationContext());
                                                               intent = new Intent(getApplicationContext(), com.example.whankung.socialherb.activity.MainFood.class);
                                                               startActivity(intent);

                                                               break;
                                                           case 3:
                                                               tv.setText("หน่วยงานที่เกี่ยวข้อง");
                                                               session = new com.example.whankung.socialherb.activity.SessionManagement(getApplicationContext());
                                                               intent = new Intent(getApplicationContext(), com.example.whankung.socialherb.activity.MainOffice.class);
                                                               startActivity(intent);

                                                               break;
                                                           case 4:
                                                               tv.setText("แชร์");
                                                               session = new com.example.whankung.socialherb.activity.SessionManagement(getApplicationContext());
                                                               intent = new Intent(getApplicationContext(), com.example.whankung.socialherb.activity.ShareF.class);
                                                               startActivity(intent);

                                                               break;
                                                           case 9:
                                                               tv.setText("Invite");
                                                               session = new com.example.whankung.socialherb.activity.SessionManagement(getApplicationContext());
                                                               intent = new Intent(getApplicationContext(), com.example.whankung.socialherb.activity.MainInvite.class);
                                                               startActivity(intent);

                                                               break;
                                                           case 10:
                                                               tv.setText("logout");

//                                                               session = new SessionManagement(getApplicationContext());
//                                                               intent = new Intent(getApplicationContext(), StartApp2.class);
//                                                               startActivity(intent);

                                                               break;
                                                       }

                                                       return false;
                                                   }
                                               }
                ).build();


    }

//        //Create the drawer
//        result = new DrawerBuilder()
//                .withActivity(this)
//                .withToolbar(toolbar)
//                .withAccountHeader(accountHeader)
//                .withHeaderDivider(false)
//                // .inflateMenu(R.menu.main)
//                .addDrawerItems(
//                        new PrimaryDrawerItem().withName("ล็อคอิน").withIcon(R.drawable.ic_login),
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_free_play).withIcon(FontAwesome.Icon.faw_gamepad),
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_custom).withIcon(FontAwesome.Icon.faw_eye),
//                        new SectionDrawerItem().withName(R.string.drawer_item_section_header),
//                        new SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(FontAwesome.Icon.faw_cog),
//                        new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(FontAwesome.Icon.faw_question).withEnabled(false),
//                        new SecondaryDrawerItem().withName(R.string.drawer_item_open_source).withIcon(FontAwesome.Icon.faw_github),
//                        new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(FontAwesome.Icon.faw_bullhorn)
//                )
////                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
////                    @Override
////                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
//////                        if (drawerItem instanceof Nameable) {
//////                            Toast.makeText(Menu.this, ((Nameable) drawerItem).getName().getText(Menu.this), Toast.LENGTH_SHORT).show();
//////                        }
////                        FragmentManager manager = getSupportFragmentManager();
////                        FragmentTransaction transaction = manager.beginTransaction();
////                        switch (position) {
////                            case 0:
////                                Intent intent = new Intent(getApplicationContext(), Login.class);
////                                startActivity(intent);
////
////
//////                                setContentView(R.layout.login);
////                                break;
////                            case 1:
//////                                setContentView(R.layout.activity_start2);
////                                intent = new Intent(getApplicationContext(), StartApp2.class);
////                                startActivity(intent);
////                                break;
////                            case 2:
////                                tv.setText("Infoghaphic");
////                                intent = new Intent(getApplicationContext(), MainInfo.class);
////                                startActivity(intent);
////
////                                break;
////
////                            case 3:
////                                tv.setText("logout");
////                                session = new SessionManagement(getApplicationContext());
////                                intent = new Intent(getApplicationContext(), MainInfo.class);
////                                startActivity(intent);
////
////
////                                break;
////                        }
////
////                        return false;
//
//                .build();
//
//
//    }
//
////                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
////                    @Override
////                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
//////                        if (drawerItem instanceof Nameable) {
//////                            Toast.makeText(Menu.this, ((Nameable) drawerItem).getName().getText(Menu.this), Toast.LENGTH_SHORT).show();
//////                        }
////                        FragmentManager manager = getSupportFragmentManager();
////                        FragmentTransaction transaction = manager.beginTransaction();
////                        switch (position) {
////                            case 0:
////                                Intent intent = new Intent(getApplicationContext(), Login.class);
////                                startActivity(intent);
////
////
////
//////                                setContentView(R.layout.login);
////                                break;
////                            case 1:
//////                                setContentView(R.layout.activity_start2);
////                                intent = new Intent(getApplicationContext(), StartApp2.class);
////                                startActivity(intent);
////                                break;
////                            case 2:
////                                tv.setText("Infoghaphic");
////                                intent = new Intent(getApplicationContext(), MainInfo.class);
////                                startActivity(intent);
////
////                                break;
////
////                            case 3:
////                                tv.setText("logout");
////                                session = new SessionManagement(getApplicationContext());
////                                intent = new Intent(getApplicationContext(), MainInfo.class);
////                                startActivity(intent);
////
////
////                                break;
//////                            case 2:
//////                                tv.setText("อาการ/โรค");
//////                                transaction.replace(R.id.frgMain, new MainDisease());
//////                                transaction.commit();
//////                                break;
//////                            case 3:
//////                                tv.setText("บทความ");
//////                                transaction.replace(R.id.frgMain, new MainArticle());
//////                                transaction.commit();
//////                                break;
//////                            case 4:
//////                                tv.setText("รายการโปรด");
//////                                transaction.replace(R.id.frgMain, new MainFavorite());
//////                                transaction.commit();
//////                                break;
//////                            case 5:
//////                                tv.setText("Infoghaphic");
//////                                transaction.replace(R.id.frgMain, new MainInfo());
//////                                transaction.commit();
//////                                break;
////
////                        }
//////                        if (drawerItem instanceof Nameable) {
//////
//////                            Intent intent = new Intent(getApplicationContext(), Login.class);
//////                            startActivity(intent);
//////
//////                        }else if (drawerItem instanceof Nameable){
//////
//////                                Intent intent2 = new Intent(getApplicationContext(), MainHerb.class);
//////                                startActivity(intent2);
//////
//////                            Toast.makeText(Menu.this, ((Nameable) drawerItem).getName().getText(Menu.this), Toast.LENGTH_SHORT).show();
//////
//////
//////
//////
//////                        }
////
////                        return false;
////                    }
////                }).build();
////    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                onBackPressed();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    @Override
//    public void onBackPressed() {
//        //handle the back press :D close the drawer first and if the drawer is closed close the activity
//        if (result != null && result.isDrawerOpen()) {
//
//            result.closeDrawer();
//        } else {
//            super.onBackPressed();
//        }
//    }


//    public void setFragment(Fragment fragment) {
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.frgMain, fragment)
//                .addToBackStack(null)
//                .commit();
//    }



//    @Override
//    public void onStart() {
//        super.onStart();
//
//        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
//        if (opr.isDone()) {
//            // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
//            // and the GoogleSignInResult will be available instantly.
//            Log.d(TAG, "Got cached sign-in");
//            GoogleSignInResult result = opr.get();
//            handleSignInResult(result);
//        } else {
//            // If the user has not previously signed in on this device or the sign-in has expired,
//            // this asynchronous branch will attempt to sign in the user silently.  Cross-device
//            // single sign-on will occur in this branch.
//            //   showProgressDialog();
//            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
//                @Override
//                public void onResult(GoogleSignInResult googleSignInResult) {
//                    //  hideProgressDialog();
//                       handleSignInResult(googleSignInResult);
//                }
//            });
//        }
//    }
//
//    // [START onActivityResult]
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//             handleSignInResult(result);
//        }
//    }
//    // [END onActivityResult]
//
//    // [START handleSignInResult]
//    private void handleSignInResult(GoogleSignInResult result) {
//        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
//        if (result.isSuccess()) {
//            // Signed in successfully, show authenticated UI.
//            GoogleSignInAccount acct = result.getSignInAccount();
//            //   mStatusTextView.setText(getString(R.string.signed_in_fmt, acct.getDisplayName()));
//            updateUI(true);
//        } else {
//            // Signed out, show unauthenticated UI.
//            updateUI(false);
//        }
//    }
//    //    // [END handleSignInResult]
////
////    // [START signIn]
//    private void signIn() {
//        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
//        startActivityForResult(signInIntent, RC_SIGN_IN);
//    }
//    // [END signIn]
//
//    // [START signOut]
//    private void signOut() {
//        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
//                new ResultCallback<Status>() {
//                    @Override
//                    public void onResult(Status status) {
//                        // [START_EXCLUDE]
//                        updateUI(false);
//                        // [END_EXCLUDE]
//                    }
//                });
//    }
//    // [END signOut]
//
//    // [START revokeAccess]
//    private void revokeAccess() {
//        Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
//                new ResultCallback<Status>() {
//                    @Override
//                    public void onResult(Status status) {
//                        // [START_EXCLUDE]
//                        updateUI(false);
//                        // [END_EXCLUDE]
//                    }
//                });
//    }
//    // [END revokeAccess]
//
//    @Override
//    public void onConnectionFailed(ConnectionResult connectionResult) {
//        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
//        // be available.
//        Log.d(TAG, "onConnectionFailed:" + connectionResult);
//    }
//
////    private void showProgressDialog() {
////        if (mProgressDialog == null) {
////            mProgressDialog = new ProgressDialog(this);
////            mProgressDialog.setMessage(getString(R.string.loading));
////            mProgressDialog.setIndeterminate(true);
////        }
////
////        mProgressDialog.show();
////    }
////
////    private void hideProgressDialog() {
////        if (mProgressDialog != null && mProgressDialog.isShowing()) {
////            mProgressDialog.hide();
////        }
////    }
//
//    private void updateUI(boolean signedIn) {
//        if (signedIn) {
//            findViewById(R.id.sign_in_button).setVisibility(View.GONE);
//            findViewById(R.id.sign_out_button).setVisibility(View.VISIBLE);
//        } else {
//            mStatusTextView.setText("signed_out");
//
//            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
//            findViewById(R.id.sign_out_button).setVisibility(View.GONE);
//        }
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.sign_in_button:
//                signIn();
//                break;
//            case R.id.sign_out_button:
//                signOut();
//                break;
////            case R.id.disconnect_button:
////                revokeAccess();
////                break;
//        }
//    }

    private void setBottomBar() {

        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

//            ImageView img = (ImageView) findViewById(R.id.action);

            @Override
            public void onTabSelected(@IdRes int tabId) {

                if (tabId == R.id.tab_herb) {

                    // Toast.makeText(MainActivity.this,"tttt",Toast.LENGTH_LONG).show();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.container, new MainHerb());
                    transaction.commit();
                  //  getSupportActionBar().setTitle("Hello");

                    tv.setText("สมุนไพร");
//                    tv.setTextColor(Color.parseColor("#228B22"));
                   tv.setTypeface(font);
                    //   img.setVisibility(View.INVISIBLE);

                } else if (tabId == R.id.tab_disease) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.container, new MainDisease());
                    transaction.commit();
                  tv.setText("อาการ/โรค");
//                    tv.setTextColor(Color.parseColor("#B22222"));
                    // img.setVisibility(View.INVISIBLE);
                } else if (tabId == R.id.tab_aritcle) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.container, new MainArticle());
                    transaction.commit();
                    tv.setText("บทความ");
//                    tv.setTextColor(Color.parseColor("#20B2AA"));
                    //  img.setVisibility(View.INVISIBLE);
                } else if (tabId == R.id.tab_favorite) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.container, new MainFavorite());
                    transaction.commit();
                    tv.setText("รายการโปรด");
//                    tv.setTextColor(Color.parseColor("#20B2AA"));
                    // img.setVisibility(View.INVISIBLE);
                }
            }


        });

    }


}