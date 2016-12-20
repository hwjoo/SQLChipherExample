package com.muhanbit.sqlchipherexample;

import android.provider.BaseColumns;

/**
 * Created by hwjoo on 2016-12-20.
 */

public class FeedReaderContract {
    public FeedReaderContract(){

    }

    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME ="news";
        public static final String COLUMN_NAME_ENTRY_ID ="news_id";
        public static final String COLUMN_NAME_TITLE ="title";
        public static final String COLUMN_NAME_SUBTITLE ="subtitle";
    }
}
