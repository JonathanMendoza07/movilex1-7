package com.andresmz.practiceexam.rest.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatsModel {

    @SerializedName("id")
    public String id;

    @SerializedName("metadata_created")
    public String metadata_created;

    @SerializedName("tags")
    public List<String> tags = null;


//    @SerializedName("list_tags")
//    public List<CatsModel.ProductItem> tagsList = null;
//
//    public class ProductItem{
//        @SerializedName("id")
//        public String id;
//
//        @SerializedName("name")
//        public String name;
//
//        @SerializedName("desc")
//        public String desc;
//    }


}
