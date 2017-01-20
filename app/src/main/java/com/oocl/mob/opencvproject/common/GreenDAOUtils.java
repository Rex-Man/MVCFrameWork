package com.oocl.mob.opencvproject.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.oocl.mob.opencvproject.greendao.db.DaoMaster;

/**
 * Created by manre on 1/19/17.
 */

public class GreenDAOUtils {
    private final static String dbName ="MVC_DB";
    private static GreenDAOUtils mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;

    public GreenDAOUtils(Context context)
    {
        this.context=context;
        openHelper = new DaoMaster.DevOpenHelper(context,dbName,null);
    }

    public static GreenDAOUtils getmInstance(Context context)
    {
        if(mInstance==null)
        {
            synchronized (GreenDAOUtils.class)
            {
                if(mInstance==null)
                {
                    mInstance=new GreenDAOUtils(context);
                }
            }
        }
        return mInstance;
    }
    private SQLiteDatabase getWritableDatabase()
    {
        if (openHelper == null) {

            openHelper = new DaoMaster.DevOpenHelper(context,dbName,null);
        }
        SQLiteDatabase db=openHelper.getWritableDatabase();
        return db;
    }
    public SQLiteDatabase getReadableDatabase()
    {
        if (openHelper == null) {

            openHelper = new DaoMaster.DevOpenHelper(context,dbName,null);
        }
        SQLiteDatabase db=openHelper.getReadableDatabase();
        return db;
    }





}
