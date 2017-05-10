//package com.example.whankung.navigity.adapter;
//
//import android.app.ListActivity;
//import android.app.ProgressDialog;
//import android.content.DialogInterface;
//import android.content.pm.ApplicationInfo;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.view.View;
//import android.view.Window;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.whankung.navigity.R;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by macbookpro on 5/4/2017 AD.
// */
//
//
//
//
//
//    public abstract class Backup extends ListActivity implements DialogInterface.OnClickListener {
//        private static final String BACKUP_LOC = "/sdcard/open manager/AppBackup/";
//        private static final int SET_PROGRESS = 0x00;
//        private static final int FINISH_PROGRESS = 0x01;
//        private static final int FLAG_UPDATED_SYS_APP = 0x80;
//
//        private ArrayList<ApplicationInfo> mAppList;
//        private TextView mAppLabel;
//        private PackageManager mPackMag;
//        private ProgressDialog mDialog;
//
//        /*
//         * Our handler object that will update the GUI from
//         * our background thread.
//         */
//        private Handler mHandler = new Handler() {
//            public void handleMessage(Message msg) {
//
//                switch(msg.what) {
//                    case SET_PROGRESS:
//                        mDialog.setMessage((String)msg.obj);
//                        break;
//                    case FINISH_PROGRESS:
//                        mDialog.cancel();
//                        Toast.makeText(Backup.this,
//                                "Applications have been backed up",
//                                Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        };
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            requestWindowFeature(Window.FEATURE_NO_TITLE);
//            setContentView(R.layout.backup_layout);
//
//            mAppLabel = (TextView)findViewById(R.id.backup_label);
//            Button button = (Button)findViewById(R.id.backup_button_all);
//
//            button.setOnClickListener(this);
//
//            mAppList = new ArrayList<ApplicationInfo>();
//            mPackMag = getPackageManager();
//
//            get_downloaded_apps();
//            setListAdapter(new TableView());
//        }
//
//
//        @Override
//        public void onClick(View view) {
//            mDialog = ProgressDialog.show(ApplicationBackup.this,
//                    "Backing up applications",
//                    "", true, false);
//
//            Thread all = new Thread(new BackgroundWork(mAppList));
//            all.start();
//        }
//
//        private void get_downloaded_apps() {
//            List<ApplicationInfo> all_apps = mPackMag.getInstalledApplications(
//                    PackageManager.GET_UNINSTALLED_PACKAGES);
//
//            for(ApplicationInfo appInfo : all_apps) {
//                if((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0 &&
//                        (appInfo.flags & FLAG_UPDATED_SYS_APP) == 0 &&
//                        appInfo.flags != 0)
//
//                    mAppList.add(appInfo);
//            }
//
//            mAppLabel.setText("You have " +mAppList.size() + " downloaded apps");
//        }
//
//
//        /*
//         * This private inner class will perform the backup of applications
//         * on a background thread, while updating the user via a message being
//         * sent to our handler object.
//         */
//        private class BackgroundWork implements Runnable {
//            private static final int BUFFER = 256;
//
//            private ArrayList<ApplicationInfo> mDataSource;
//            private File mDir = new File(BACKUP_LOC);
//            private byte[] mData;
//
//            public BackgroundWork(ArrayList<ApplicationInfo> data)  {
//                mDataSource = data;
//                mData =  new byte[BUFFER];
//
//			/*create dir if needed*/
//                File d = new File("/sdcard/open manager/");
//                if(!d.exists()) {
//                    d.mkdir();
//
//                    //then create this directory
//                    mDir.mkdir();
//
//                } else {
//                    if(!mDir.exists())
//                        mDir.mkdir();
//                }
//            }
//
//            public void run() {
//                BufferedInputStream mBuffIn;
//                BufferedOutputStream mBuffOut;
//                Message msg;
//                int len = mDataSource.size();
//                int read = 0;
//
//                for(int i = 0; i < len; i++) {
//                    ApplicationInfo info = mDataSource.get(i);
//                    String source_dir = info.sourceDir;
//                    String out_file = source_dir.substring(source_dir.lastIndexOf("/") + 1, source_dir.length());
//
//                    try {
//                        mBuffIn = new BufferedInputStream(new FileInputStream(source_dir));
//                        mBuffOut = new BufferedOutputStream(new FileOutputStream(BACKUP_LOC + out_file));
//
//                        while((read = mBuffIn.read(mData, 0, BUFFER)) != -1)
//                            mBuffOut.write(mData, 0, read);
//
//                        mBuffOut.flush();
//                        mBuffIn.close();
//                        mBuffOut.close();
//
//                        msg = new Message();
//                        msg.what = SET_PROGRESS;
//                        msg.obj = i + " out of " + len + " apps backed up";
//                        mHandler.sendMessage(msg);
//
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                mHandler.sendEmptyMessage(FINISH_PROGRESS);
//            }
//        }
//
//        private static class AppViewHolder {
//            TextView top_view;
//            TextView bottom_view;
//            ImageView icon;
//            ImageView check_mark;
//        }
//
//        private class TableView extends ArrayAdapter<ApplicationInfo> {
//
//            private TableView() {
//                super(ApplicationBackup.this, R.layout.tablerow, mAppList);
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                AppViewHolder holder;
//                ApplicationInfo info = mAppList.get(position);
//
//                if(convertView == null) {
//                    LayoutInflater inflater = getLayoutInflater();
//                    convertView = inflater.inflate(R.layout.tablerow, parent, false);
//
//                    holder = new AppViewHolder();
//                    holder.top_view = (TextView)convertView.findViewById(R.id.top_view);
//                    holder.bottom_view = (TextView)convertView.findViewById(R.id.bottom_view);
//                    holder.check_mark = (ImageView)convertView.findViewById(R.id.multiselect_icon);
//                    holder.icon = (ImageView)convertView.findViewById(R.id.row_image);
//                    holder.icon.setMaxHeight(40);
//                    convertView.setTag(holder);
//
//                } else {
//                    holder = (AppViewHolder) convertView.getTag();
//                }
//
//                holder.top_view.setText(info.processName);
//                holder.bottom_view.setText(info.packageName);
//
//                //this should not throw the exception
//                try {
//                    holder.icon.setImageDrawable(mPackMag.getApplicationIcon(info.packageName));
//                } catch (PackageManager.NameNotFoundException e) {
//                    holder.icon.setImageResource(R.drawable.appicon);
//                }
//
//                return convertView;
//            }
//        }
//    }
//
//
//
