package com.example.dhanoushodhi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "DetailsActivity";

    private final static String DISEASE_SELECTED = "diseaseName";

    String disease;
    TextView tvDetails;
    ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        disease = getIntent().getStringExtra(DISEASE_SELECTED);
        /*Log.d(TAG, "onCreate called.   --> " + disease );*/

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(disease);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvDetails = findViewById(R.id.tv_disease_details);
        img1 = findViewById(R.id.iv_sample);

        viewDetails(disease);
    }

    @SuppressLint("SetTextI18n")
    private void viewDetails(String disease) {
        if ("ধানের পাতা ব্লাস্ট".equals(disease)) {
            tvDetails.setText("রোগ পরিচিতিঃ \n" +
                    "\tব্লাস্ট ধানের একটি ছত্রাকজনিত রোগ। বাংলাদেশে এটি ধানের অন্যতম প্রধান রোগ। রোগটি বোরো ও আমন মৌসুমে বেশি হয়\n" +
                    "এবং চারা অবস্থা থেকে ধান পাকার আগ পর্যন্ত যেকোন সময় দেখা যায়। এ রোগ দেশের উত্তরাথ্ল ছাড়া আর সব জায়গাতেই\n" +
                    "ধানের ক্ষতি করে থাকে। এটি পাতা ব্লাস্ট, গিট ব্লাম্ট ও শিষ ব্লাম্ট নামে পরিচিত। অনুকূল অবন্থায় রোগটি দ্রুত বিস্তার লাভ করে\n" +
                    "এবং ধানের প্রভূত ক্ষতি করে থাকে। রোগপ্রবণ জাতে রোগটি হলে শতকরা ৮০ ভাগ পর্যন্ত ফলন কমে যায়।\n" +
                    "\n" +
                    "রোগ চেনার প্রয়োজনীয়তাঃ \n" +
                    "\tরোগ দমনের সঠিক কার্যক্রম নেয়ার জন্য রোগটি সঠিকভাবে চেনা প্রয়োজন। রোগ সম্পর্কে সঠিক ধারণা না থাকলে রোগের ভুল\n" +
                    "চিকিৎসা করার আশংকাই বেশি থাকে এবং এতে অর্থ, সময় ও শ্রমের অপচয় হয়। তাই আপনার জমিতে কি রোগ হল তা জানা\n" +
                    "খুবই প্রয়োজন।\n" +
                    "\n" +
                    "\n" +
                    "রোগ চিনার উপায়ঃ \n" +
                    "\tব্লাস্ট রোগটি ধানের পাতা, গিট, শিষের গোড়া বা শাখা প্রশাখা এবং বীজে আক্রমণ করে থাকে।\n" +
                    "\n" +
                    "পাতা ব্লস্ট: আক্রান্ত পাতায় প্রথমে হালকা ধূসর বা নীলচে রঙের ভিজা ভিজা দাগ দেখা যায়। আস্তে আস্তে তা বড় হয়ে মাঝখানটা ধূসর বা সাদা ও কিনারা বাদামি রঙ ধারণ করে। দাগগুলো একটু লম্বাটে হয় এবং দেখতে অনেকটা চোখের মত। অনুকূল আবহাওয়ায় রোগটি দ্রুত বৃদ্ধি পায় এবং একাধিক দাগ মিশে গিয়ে বড় দাগের সৃষ্টি করে। শেষ পর্যন্ত পুরো পাতা, এমনকি পুরো গাছটিই মারা যেতে পারে।\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "রোগটি বেশি হওয়ার অনুকূল পরিবেশঃ \n" +
                    "» হালকা মাটি যার পানি ধারণ ক্ষমতা কম\n" +
                    "» ঠাপ্তা আবহাওয়ায়\n" +
                    "» পাতায় শিশির জমে থাকলে\n" +
                    "» অতিরিক্ত নাইট্রোজেন সার ব্যবহার করলে\n" +
                    "» রোগাক্রান্ত বীজ ব্যবহার করলে\n" +
                    "» রোগপ্রবণ ধানের জাতের চাষ করলে\n" +
                    "» জমিতে বা জমির আশপাশে অন্যান্য পোষক গাছ বা আগাছা থাকলে" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "রোগ হওয়ার আগে করণীয়ঃ \n" +
                    "» মাটিতে জৈব সার ব্যবহার করা\n" +
                    "» সুষম মাত্রায় রাসায়নিক সার ব্যবহার করা\n" +
                    "» সুহবীজ ব্যবহার করা\n" +
                    "» রোগ প্রতিরোধ ক্ষমতাসম্পন্ন জাতের চাষ করা (বোরো মৌসুমে বিআর ৩, ৬, ৭, ১২, ১৪, ১৬, ১৭. ব্রি ধান২৮ ও 8৫; আউশ মৌসুমে বিআর ৩, ৬, ৭, ১২, ১৪, ১৬, ২০, ২১, ২৪; আমন মৌসুমে বিআর-৪, ৫,১০, ব্রি ধান৩২, ব্রি ধান৩৩ ও ব্রি ধান৪৪)\n" +
                    "\n" +
                    "\n" +
                    "রোগ হওয়ার পরে করণীয়ঃ \n" +
                    "» রোগের প্রাথমিক অবস্থায় বিঘা প্রতি ৫ কেজি পটাশ সার উপরিপ্রয়োগ করা\n" +
                    "» আবহাওয়া অনুকূল হলে রোগের প্রাথমিক অবস্থায় ট্রপার/নেটিভো/জিল নামক ছত্রাকনাশক বিঘাপ্রতি ১০৭ মিলিলিটার ১০০ লিটার পানিতে মিশিয়ে প্রয়োগ করুন।\n" +
                    "\n" +
                    "ব্লাস্টের আক্রমণের ঝুঁকি এড়াতে রোগপ্রবণ ধানের চাষ থেকে বিরত থাকা এবং সতর্কতার সাথে পরিমিত ইউরিয়া সার ব্যবহার করা দরকার ৷ তবে ইউরিয়া সারের চাহিদা নির্ধারণের জন্য এলসিসি দিয়ে ধানের পাতার রঙ মিলিয়ে নেয়া উত্তম ।");
            Glide.with(this).load(R.drawable.leafblast).into(img1);
        } else if ("লিফ স্কোল্ড".equals(disease)) {
            tvDetails.setText("রোগ পরিচিতিঃ \n" +
                    "\tপাতার ফোস্কা দাগ ধানের একটি ছত্রাকজনিত রোগ । এটি মাই ক্রোডকিয়াম অরাইজি নামক এক ধরণের ছত্রাকের আক্রমণে হয় । বাংলাদেশের ধানের প্রধান রোগগুলির এটি একটি । রোগটি আমন ও বোরো মৌসুমে বেশি হয় এবং চারা অবস্থা থেকে ধানের ফুল আসা পর্যন্ত যে কোন সময় দেখা যায় ৷ তবে ধানের থোড় অবস্থায় রোগটি বেশি দেখা যায় ৷ রোগকাতর জাতে রোগটি হলে ধানের ফলন শতকরা ৩০ ভাগ পর্যন্ত কমে যায় ।\n" +
                    "\n" +
                    "\n" +
                    "রোগটি চিনার উপায়ঃ \n" +
                    "\tরোগ দমনের সঠিক কার্য্রম নেয়ার জন্য রোগটি সঠিকভাবে চেনা প্রয়োজন । রোগ সম্পর্কে সঠিক ধারণা না থাকলে রোগের ভুল চিকিৎসা করার আশংকাই বেশি থাকে এবং এতে অর্থ, সময় ও শ্রমের অপচয় ছাড়া কোন লাভ হয় না। তাই আপনার জমিতে কী রোগ হল তা জানা খুবই প্রয়োজন । আর রোগ চিনতে হলে রোগের লক্ষণ সম্পর্কে সম্যক ধারণা থাকা প্রয়োজন ।\n" +
                    "\n" +
                    "\n" +
                    "রোগের লক্ষণঃ \n" +
                    "\tরোগটি ধান গাছে বিভিন্ন ধরণের লক্ষণ সৃষ্টি করে থাকে । তবে সচরাচর পাতায় যে লক্ষণটি বেশি দেখা যায় তা হল পাতার আগা থেকে দাগ আরম্ভ হয়ে নিচের দিকে বাড়তে থাকে। প্রথমত পাতায় ভেজা ভেজা জলপাই রঙের দাগ হর যা আস্তে আস্তে গাঢ় বাদামি ও হালকা বাদামি দাগে পরিণত হয় এবং পাশাপাশি সন্নিবেশিত হয়ে ঢেউ এর মত দাগের সমাহার ঘটায়। তবে অনেক সময় গাঢ় বাদামি আড়াআড়ি রেখা না হয়ে শুধই বাদামি রঙ হয়ে দাগ বাড়তে থাকে এবং আক্রান্ত অংশ ধীরে ধীরে শুকনা খড়ের রঙ ধারণ করে। অনেক সময় পাতার কিনারা থেকে দাগ সৃষ্টি হয়, যা পাতায় আড়াআড়ি বাড়তে থাকে এবং আক্রান্ত অংশের উপরের ও নিচের অংশ সবুজ থাকে।\n" +
                    "\n" +
                    "\n" +
                    "রোগের অনুকূল অবস্থাঃ \n" +
                    "» আর্দ্র ও ঠা্ড আবহাওয়ায় (২০ সেঃ)\n" +
                    "» বেশি পরিমাণে নাইট্রোজেন সার ব্যবহারের ফলে\n" +
                    "» আক্রান্ত বীজ ব্যবহার করলে\n" +
                    "» জমিতে বা আশেপাশে পোষক আগাছা থাকলে" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "দমন ব্যবস্থাপনাঃ \n" +
                    "» আক্রান্ত খড়কুটা জমিতে পুড়িয়ে ফেলা\n" +
                    "» রোগমুক্ত জমি থেকে বীজ সংগ্রহ করা\n" +
                    "» ছত্রাক নাশকের ব্যবহার : বিঘাপ্রতি ৩০০ গ্রাম থিওভিট, সালফোলাক, মাইক্রোথিওল বা কুমুলাস থোড় অবস্থায় প্রয়োগ করা।");
            Glide.with(this).load(R.drawable.leaf_scaled).into(img1);
        } else if ("শেলথ ব্লাইট".equals(disease)) {
            tvDetails.setText("রোগ পরিচিতিঃ \n" +
                    "\tএ রোগে প্রাথমিক অবস্থায় পানির উপরিভাগে খোলের উপর পানি ভেজা হালকা সবুজ রঙের দাগ পড়ে। ডিম্বাকৃতি বা বর্তুলাকার এ সব দাগ প্রায় ১ সেন্টিমিটার লম্বা হয় এবং বড় হয়ে দাগগুলো ২-৩ সেন্টিমিটার পর্যন্ত বড় হতে পারে। কয়েকটি দাগ পরে একত্রে মিশে যায়। প্রত্যেকটি দাগের সীমারেখা এবং রঙের বৈচিত্র্য একটা আক্রান্ত এলাকার বৈশিষ্ট্যকে ফুটিয়ে তোলে। তখন আক্রান্ত খোলটার উপর ছোপ ছোপ দাগ মনে হয়। অনুকুল এবং আর্দ্র পরিবেশে আক্রান্ত কান্ডের নিকটবর্তী পাতাগুলোও আক্রান্ত হতে পারে। সাধারণতঃ ফুল হওয়া থেকে ধান পাকা পর্যন্ত রোগের লক্ষণ স্পষ্ট দেখা যায়। আক্রান্ত জমি মাঝে মাঝে পুড়ে বসে যাওয়ার মত মনে হয় । রোগের প্রকোপ বেশি হলে ধান চিটা হয়ে যায়।\n" +
                    "\n" +
                    "\n" +
                    "খোলপোড়া রোগের বিস্তার পদ্ধতিঃ \n" +
                    "\tমাটি ও পরিত্যাক্ত খড়কুটায় ছত্রাক-গুটিকা বা ছত্রাক-কাণ্ড রোগের প্রাথমিক উৎস হিসাবে কাজ করে । রোগলীবাণু মূলত বৃষ্টি,\n" +
                    "সেচ বা বন্যার পানির মাধ্যমে এক গাছ থেকে অন্য গাছে এবং এক জমি থেকে অন্য জমিতে ছড়ায় । কোন কোন সময় ছত্রাকের অনুজীব বাতাসের মাধ্যমেও বিস্তারলাভ করতে পারে ৷ অধিক তাপমাত্রা ও আর্দ্রতা এবং বেশি পরিমাণে ইউরিয়া ব্যবহার করলে রোগটির প্রকোপ বেড়ে যায়।" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "খোলপোড়া রোগের দমন ব্যবস্থাপনাঃ \n" +
                    "\n" +
                    "রোগ হওয়ার আগে করণী\n" +
                    "* বছরে অন্তত একবার, বিশেষ করে আমন ধান কাটার পর আক্রান্ত খড়কুটা জমিতে পুড়িয়ে ফেলা\n" +
                    "* দূরে দূরে সারি করে চারা লাগানো (২০ ১ ২০ সেন্টিমিটার)\n" +
                    "* পর্যায়ক্রমে জমি শুকিয়ে আবার পানি দেয়া\n" +
                    "* সুষম মাত্রায় সার ব্যবহার করা\n" +
                    "* রোগ সহনশীল জাত, বিআর২২, ব্রি ধান৩২, ব্র ধান৩৮, ব্রি ধান৩৯, ব্রি ধান৪১, ব্রি ধান৪৮ ও ব্রি ধান৪৯-এর চাষ করা\n" +
                    "\n" +
                    "\n" +
                    "রোগ হওয়ার পরে করণীয়\n" +
                    "* রোগ দেখা দেয়ার পর বিঘা প্রতি ৫ কেজি পটাশ সার ১৫ দিন অন্তর সমান দুই কিস্তিতে প্রয়োগ করুন\n" +
                    "* প্রতি ৩৩ শতাংশের বিঘায় একোনাজল, ইভাইল্ট, এনভিল, ফলিকুর, কনটাফ অথবা টিস্ট ৬৭ মিলি অথবা ফোরাস্টিন, এগবেন, সিন্ডাজিম, ইভাজিম, জেনুইন বা ভলকেন ১৩৪ গ্রাম সমান দুই কিস্তিতে ১০০ লিটার পানিতে মিশিয়ে প্রয়োগ করুন।");
            Glide.with(this).load(R.drawable.sheath_blight).into(img1);
        } else if ("শেলথ রট".equals(disease)) {
            tvDetails.setText("রোগ পরিচিতিঃ \n" +
                    "\tখোলপচা ধানের ছত্রাকজনিত একটি রোগ । বাংলাদেশে ধানের প্রধান রোগগুলোর মধ্যে খোলপচা অন্যতম ক্ষতিকারক রোগ। এ রোগ বাংলাদেশ ছাড়াও বিভিন্ন ধান উৎপাদনকারী দেশে দেখা যায়। রোগটি সাধারণত ধানের থোড় অবস্থা থেকে শুরু হয়। বাংলাদেশের প্রায় সকল অঞ্চলেই রোগটি দেখা যায় এবং এ রোগ ধানের ফলন ও গুণগতমান কমিয়ে দেয়।\n" +
                    "\n" +
                    "\n" +
                    "রোগটি চেনার উপায়ঃ \n" +
                    "\tরোগটি ডিগপাতার খোলের উপরের অংশে শুরু হয়। শুরুতে হোট ও গোলাকার বা অনিয়মিত আকারের বাদামি দাগ হয়। আস্তে আস্তে দাগ বড় হতে থাকে এবং কালচে হতে ধূসর রঙের হয়। রোগের মাত্রা বেশি হলে শিষ বের হতে পারে না অথবা রোগের তীব্রতা অনুযারী আংশিক বের হয় তবে ধান বেশির ভাগ কালো ও চিটা হয়ে যায়। আক্রান্ত শিষ খোল থেকে খুলে দেখলে সাদা সাদা ছত্রাক কাণ্ড দেখা যায়। অনেক সময় নিচের দিকের খোলও আক্রান্ত হয় কিন্তু ওই অবস্থায় ফসলের কোন ক্ষতি হয় না।\n" +
                    "\n" +
                    "রোগের অনুকূল অবস্থা \n" +
                    "» রোগাক্রান্ত বীজের ব্যবহার\n" +
                    "» জমিতে পড়ে থাকা আক্রান্ত খড়কুটা\n" +
                    "» অধিক তাপমাত্রা (৩০-৩১ ডিগ্রী সেন্টিগ্রেড) ও আর্দ্রতা\n" +
                    "» পোকা বা অন্য কোন কারণে খোলে ক্ষত থাকা\n" +
                    "» অধিক পরিমাণে নাইট্রোজেন সারের ব্যবহার" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "দমন ব্যবস্থাপনা\n" +
                    "» আক্রান্ত খড়কুটা জমিতে পুড়িয়ে ফেলা\n" +
                    "» সুস্থ বীজের ব্যবহার\n" +
                    "» পরিমিত সারের ব্যবহার\n" +
                    "» বীন্রশোধন করা (ব্যাভিস্টিন ৩ গ্রাম/কেজি বীজ)\n" +
                    "» বিঘা প্রতি ১৩৩ সিসি টিল্ট প্রয়োগ করা");
            Glide.with(this).load(R.drawable.sheath_rot).into(img1);
        } else if ("টুংরো রোগ".equals(disease)) {
            tvDetails.setText("রোগ পরিচিতিঃ \n" +
                    "\tটুধরো ভাইরাসজনিত একটি মারাত্মক ক্ষতিকারক রোগ ৷ এ রোগের আক্রমণে ধান ফসলের ব্যাপক ক্ষতি হয় । প্রতি ২-৩ বছর পর পর এ রোগের ব্যাপক আক্রমণ দেখা যায়। আত্রনন্ত এলাকাসমূহের মধ্যে চট্টগ্রাম, ঢাকা, ময়মনসিংহ, কুমিল্লা এবং বৃহত্তর বরিশাল উল্লেখযোগ্য ।\n" +
                    "\n" +
                    "\n" +
                    "রোগের কারণঃ \n" +
                    "\tরাইস টুধরো ভাইরাস নামক এক ধরনের অতি সৃক্ষ্ম ভাইরাস দ্বারা এ রোগ হয়ে থাকে। সবুজ পাতাফড়িং উক্ত ভাইরাস ছড়ায়। \n" +
                    "\n" +
                    "\n" +
                    "রোগটি চেনার উপায়ঃ \n" +
                    "»  গাছহলদে অথবা কমলা বর্ণের হয়\n" +
                    "» গাছ খাটো হয়ে বসে যায়\n" +
                    "» গাছের কচি পাতা হলদে, চওড়া, খাটো বা মোচড়ানো হয়\n" +
                    "» আক্রান্ত পাতাগুলো ভূমির দিকে নুয়ে পরে\n" +
                    "» একাধিক পাতার গোড়া বা খোল একত্রে পুরনো পাতার খোলের মধ্যে আটকে থাকে\n" +
                    "» কুশির সংখ্যা কম হয়\n" +
                    "\n" +
                    "\n" +
                    "রোগটি বিস্তার লাভের পদ্ধতিঃ \n" +
                    "\tসবুজ পাতাফড়িং আক্রান্ত গাছ থেকে ভাইরাস সংগ্রহ করে সুস্থ গাছে ছড়ায়, ফলে সুস্থ গাছ আক্রান্ত হয়। আক্রমণের ২-৩ সপ্তাহের মধ্যেই রোগের লক্ষণ প্রকাশ পায়। আক্রান্ত ক্ষেতে প্রথমে বিক্ষিপ্তভাবে দু'একটা করে গাছে রোগ দেখা গেলেও ক্রমে তা সবুজ পাতাফড়িং-এর মাধ্যমে আশপাশের গাছে ছড়িয়ে পড়ে (চিত্র-৪)। এভাবে মাঠের পর মাঠ আক্রান্ত হয় । চারা অবস্থা অথবা কুশি বৃদ্ধি অবস্থায় আক্রমণ হলে রোগের লক্ষণ তাড়াতাড়ি গ্রকাশ পায় এবং ক্ষতির পরিমাণও বেশি হয় ।" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "দমন ব্যবস্থাপনাঃ \n" +
                    "» টুংরো আক্রান্ত জমির আশেপাশে বীজতলা তৈরি না করা, সর্বদা বীজতলায় বাহক পোকা দমনের ব্যবস্থা নেয়া;\n" +
                    "» বীজতলা তৈরি করার সময় আশপাশের জমিতে পরিত্যক্ত টুংরো আক্রান্ত ধানগাছ, বাওয়া ধান, মুড়িধান ও আড়ালী ঘাস থাকলে তা তুলে ধ্বংশ করা;\n" +
                    "» চারা রোপণের পর থেকে কুশি বৃদ্ধির শেষ পর্যস্ত ক্ষেতে বাহক পোকা দেখা মাত্র তা সকল চাষি মিলে দমন করা, হাতজালের প্রতি টানে একটি করে বাহক পোকা দেখা দিলে কীটনাশক প্রয়োগ করা;\n" +
                    "» প্রাথমিক অবস্থায় টুংরো আক্রান্ত গাছ দেখা মাত্র তা মাটিতে পুতে ফেলা ।");
            Glide.with(this).load(R.drawable.tungro).into(img1);
        } else if ("উফরা রোগ".equals(disease)) {
            tvDetails.setText("রোগ পরিচিতিঃ \n" +
                    "\tপ্রতি বছর প্রায় দুই লাখ হেক্টর জমির ধান উফরা রোগে আক্রান্ত হয়। সাধারণত শতকরা ৪০-১০০ ভাগ ফলন নষ্ট হয়ে যেতে পারে। বিভিন্ন এলাকায় এ রোগ ডাকপোড়া, স্বীলে যাওয়া, পুড়ে যাওয়া, লোনা লাগা ইত্যাদি নামে পরিচিত। বৃহত্রর বরিশাল, পটুয়াখালি, ফরিদপুর, কুমিল্লা, সিলেট, খুলনা ও ঢাকা জেলায় এ রোগ দেখা যায়। রোপা আমন, বোরো এমনকি আউশ ধানেও এ রোগ দেখা যায়।\n" +
                    "\n" +
                    "\n" +
                    "রোগের কারণ ও লক্ষণঃ \n" +
                    "\tএক ধরনের কৃমি দ্বারা এ রোগ হয়। কৃমি ধান গাছের আগার কচি অংশের রস শুষে খায়, ফলে পাতা ও খোলের সংযোগন্থলে সাদা ছিটা-ফোটা দাগ দেখা দেয়। আক্রমণ বেশি হলে ডিগ পাতা পুরোটাই সাদা হয়ে যেতে পারে । সাদা দাগ ক্রমে বাদামি রঙে পরিণত হয় এবং পরে এ দাগ বেড়ে সম্পূর্ণ পাতাটাই শুকিয়ে ফেলে। ফলে অনেক সময় থোড় হতে ছড়া বের হতে পারে না বা বের হলেও অর্ধেক বা আংশিক বের হয়। তবে ধান খুব চিটা ও অপুষ্ট হয়। ছড়া বের হতে না পারলে তা ভিতরে মোচড়ানো অবস্থায় থাকে। আত্রণন্ত গাছ সুস্থ গাছের তুলনায় কিছুটা বেঁটে হয়। আক্রমণ বেশি হলে জমিতে তেমন কোন ফলন হয়লা।\n" +
                    "\n" +
                    "\n" +
                    "আক্রমণের অনুকূল অবস্থা ও বিস্তার পদ্ধতিঃ \n" +
                    "\tশুকনো আবহাওয়া ও কম তাপমাত্রার জন্য বোরো ধানে এ রোগের প্রকোপ কিছুটা কম হয়। বাতাসের তাপমাত্রা ২৮-৩০ ডিশ্রী সেন্টিঘেড, বায়ুর আর্দ্রতা শতকরা ৭০ ভাগের বেশি, ঘন ঘন বৃষ্টি ও জমিতে পানি জমে থাকা এ রোগের জন্য বিশেষ উপযোগী। এই কৃমি ফসল কাটার পর আক্রান্ত গাছে কুগ্ুলী পাকিয়ে অথবা স্বাভাবিক অবস্থায় বেঁচে থাকতে পারে। আক্রান্ত জমির পরিত্যক্ত নাড়া, খড়কুটা শিষে বা ঝড়ে যাওয়া ধানে এবং মাটিতে কোন খাদ্য ছাড়াই এই কৃমি কুন্ডলী পাকিয়ে ৬-৮ মাস বেঁচে থাকতে পারে। প্রাথমিক উদ্ধস থেকে বৃষ্টি, সেচ অথবা বন্যার পানিতে কৃমি বের হয়ে আসে এবং ধান গাছে আক্রমণ করে।" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "দমন পদ্ধতিঃ \n" +
                    "» উফরা রোগ প্রতিরোধ করতে পারে এমন কোন উফশী ধান এখনও পাওয়া যায়নি। তবে রায়দা এবং বাজাইল জাতীয় স্থানীয় জলি আমন ধানে প্রতিরোধ ক্ষমতা আছে।\n" +
                    "» রোগাক্রান্ত জমির ফসল কাটার পর নাড়া ও খড় জমিতে পুড়ে ফেলা।\n" +
                    "» ঘাস জাতীয় আগাছা, আক্রান্ত ধানের গোড়া থেকে গজানো কুশি বা মুড়ি ধান গাছ ধ্বংস করা।\n" +
                    "» রোগাক্রান্ত জমির খড় গরুকে খাওয়ানোর জন্য বাড়িতে স্তুপ দিয়ে না রেখে বরং পুড়ে ফেলা ভাল, কারণ এ খড় কৃমি বহন করে ও পরে বৃষ্টির পানির সাথে জমিতে গড়িয়ে আসে।\n" +
                    "» যেখানে সম্ভব সেখানে বছরের প্রথম বৃষ্টির পর জমি চাষ দিয়ে ১৫-২০ দিন শুকানো।\n" +
                    "» ধান ছাড়াও জমিতে অন্যান্য ফসলের চাষ করা।\n" +
                    "» বীজতলা থেকে উরা আক্রান্ত চারা বেছে জমিতে সুহথ চারা লাগানো।\n" +
                    "» ফুরাডান ৫ জি নামক দানাদার কৃমিনাশক বিঘা প্রতি ৩ কেজি হিসেবে ফসলের প্রথম অবস্থায় ক্ষেতে ছিটিয়ে মিশিয়ে দেয়া। কুরাটার ৫জি দিয়েও ভাল ফলাফল পাওয়া যায় ।\n" +
                    "» উফরা আক্রান্ত এলাকায় প্রতি কাঠা বীজতলাতে ১৫০ গ্রাম দানাদার কৃমিনাশক ছিটিয়ে দিয়ে ধানের বীজ বুনলে চারাতে এ রোগ হওয়ার আশংকা কম থাকে।\n" +
                    "» চারা লাগানোর ১২-২০ ঘন্টা আগে বীজতলা থেকে উঠিয়ে তার শিকড় কৃমিনাশকের ১.৫% দ্রবণে (এক লিটার পানিতে ১.৫ গ্রাম কৃমিনাশক) ভিজিয়ে রেখে পরে তা জমিতে লাগানো।");
            Glide.with(this).load(R.drawable.ufra).into(img1);
        } else if ("ধানের কাণ্ড পচা রোগ".equals(disease)) {
            tvDetails.setText("ধানের কান্ড পচা/ Stem rot of Rice ( Sclerotium oryzae ) একটি ছত্রাকজনিত রোগ।\n" +
                    "\n" +
                    "রোগের লক্ষণঃ\n" +
                    "* এই রোগ সাধারণত কুশি ও বাড়ন্ত অবস্থায় ধান ক্ষেতে পরিলক্ষিত হয়ে থাকে।\n" +
                    "* রোগ জীবাণু মাটিতে থাকার কারণে আক্রান্ত জমিতে সেচ দিলে সেচের পানি দিয়ে রোগ জীবাণু সহজেই কাণ্ডে আক্রমণ করতে পারে।\n" +
                    "* প্রথমে কুশির বাইরের দিকের খোলে আক্রমণ করে। ফলে ধান গাছের বাইরের খোলে কিছুটা আয়তাকার গাঢ় কালচে দাগ পড়ে।\n" +
                    "* এছাড়াও শীষকে আবৃতকারী পাতার খোলে গোলাকার দাগ পড়ে এবং দাগের কেন্দ্র কিছুটা ধূসর ও কিনারা বাদামি রঙের হয়ে যায়।\n" +
                    "* পরবর্তীতে দাগগুলো ধীরে ধীরে বড় আকার ধারণ করে খোলে এবং কাণ্ডের ভিতরে প্রবেশ করে।\n" +
                    "* ফলশ্রুতিতে আক্রান্ত কাণ্ড পচে গিয়ে ধান গাছ হেলে ভেঙ্গে পড়ে এবং ধান চিটা ও অপুষ্ট হয়ে থাকে।" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "দমন ব্যবস্থাপনাঃ\n" +
                    "* রোগ সহনশীল ক্ষমতা সম্পন্ন জাত যেমন- বিআর ১০, বিআর ১১, বিআর ২২, বিআর ২৩, ব্রি ধান ৩১, ব্রি ধান ৩২ ইত্যাদি চাষ করা যেতে পারে।\n" +
                    "* জমিতে ঘন করে চারা না লাগিয়ে লাইন ও লোগো পদ্ধতিতে চারা রোপণ করতে হবে।\n" +
                    "* জমিতে সুষম সার ব্যবহার করতে হবে।\n" +
                    "* ধান ক্ষেতে এই রোগ পরিলক্ষিত হওয়া মাত্র জমিতে পানি শুকিয়ে আবার পানি দিতে হবে।\n" +
                    "* আক্রান্ত জমিতে ইউরিয়া সারের ব্যবহার কমিয়ে দিয়ে পটাশ সার বেশি দিতে হবে।\n" +
                    "* জমিতে রোগের আক্রমণ বেশি হলে প্রোপিকোনাজল ( টিল্ট/ প্রউড ১ মিলি/ লিটার) বা হেক্সাকোনাজল গ্রুপের ছত্রাকনাশক ( কনটাফ/ কনজা ১ মিলি/ লিটার) অথবা টেবুকোনাজল গ্রুপের ছত্রাকনাশক ( ফলিকুর ১ মিলি/ লিটার ) অথবা থায়োপেনেট মিথাইল জাতীয় ছত্রাকনাশক (টপসিন এম ৭০ ডব্লিউপি) ২ গ্রাম/১ লিটার পানিতে মিশিয়ে ১০-১৫ দিন পর পর স্প্রে করতে হবে।\n" +
                    "* আক্রান্ত জমি থেকে পরবর্তী বছরের জন্য বীজ সংগ্রহ করা যাবে না।");
            Glide.with(this).load(R.drawable.kando_pocha).into(img1);
        } else if ("বাকানি রোগ".equals(disease)) {
            tvDetails.setText("রোগ পরিচিতিঃ \n" +
                    "\tধানের বাকানি একটি পরিচিত রোগ । ছত্রাকজনিত এই রোগ গোড়া পচা বা সাদা ডাটা রোগ নামেও পরিচিত এবং পৃথিবীর প্রায় সকল ধান উৎপাদনকারী দেশেই এটি দেখা যায় । ১৯৫৩ সালে প্রথম এই রোগ বাংলাদেশে দেখা যায় এবং তখন থেকে সর্বত্রই এই রোগের বিস্তার ঘটে । দেশের উত্তর পূর্বাঞ্চলে এর প্রাদুর্ভাব বেশি । বিশেষতঃ সিলেট অঞ্চলে এটি একটি বড় সমস্যা । এ রোগের আক্রমণে ১৫% পর্যস্ত ফলন ঘাটতি হতে পারে । কোন কোন দেশে এই রোগ দ্বারা ৪০% পর্যস্ত ফলন ঘাটতির নজির পাওয়া গেছে।\n" +
                    "\n" +
                    "\n" +
                    "বাকানি রোগের লক্ষণঃ \n" +
                    "\tধানের বাকানী রোগের লক্ষণ বীজতলা ও মূল ধানের জমিতে পরিলক্ষিত হয়। আক্রান্ত চারা বা গাছ লম্বা হয়ে যায় এবং কখনো কখনো সুস্থ গাছের চেয়ে দ্বিগুন লম্বা হয়ে যায় ৷ এই গাছগুলো লিকলিকে হয় এবং ফ্যাকাশে সবুজ রঙ ধারণ করে । আক্রান্ত গাছ বেঁচে থাকলেও শেষ পর্যন্ত ছড়ায় ধান চিটা হয়ে যায়। কান্ডের গোড়ায় ১ম, ২য় ও ৩য় গিট বা পর্বসন্ধিতে অস্থানীক শিকড় গজায়। ধান গাছ যখন মারা যায় তখন গাছের নিচের দিকের অংশে সাদা বা গোলাপি বর্ণের ছত্রাক লক্ষ্য করা যায়। এই ছত্রাক হতে অসংখ্য স্পোর সৃষ্টি হয় ।\n" +
                    "\n" +
                    "\n" +
                    "রোগ বিস্তার পন্ধতিঃ \n" +
                    "\tবাকানি রোগটি রোগাক্রান্ত বীজের মাধ্যমে ছড়ায় । মাটি ও ফসলের পরিত্যাক্ত অংশেও রোগজীবানু বেঁচে থাকে । মাঠে বীজ অঙ্কুরিত হওয়ার সময় ছত্রাক স্পোর বীজকে আক্রমণ করে । ফলে চারা গাছে বাকানির উপসর্গ দেখা দেয়। সাধারণত ঠান্ডা আবহাওয়ায় এই রোগ কম হয়। জমির তাপমাত্রা ৩০ ডিগ্রী সেন্টিগ্রেড এর বেশি হলে এই রোগের আক্রমণ বেড়ে যায় । মাটিতে অধিক মাত্রায় নাইট্রোজেন (ইউরিয়া) থাকলেও বাকানি রোগের দ্রুত বিস্তৃতি ঘটতে পারে ।" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "দমনব্যবস্থাপনাঃ \n" +
                    "» স্বাস্থ্যসম্মত ও রোগমুক্ত বীজ ব্যবহার\n" +
                    "» পরিমিত মাত্রায় ইউরিয়া সার ব্যবহার\n" +
                    "» আক্রান্ত গাছ সংগ্রহ করে গুঁড়িয়ে ফেলা\n" +
                    "» আগাছা ও খড়কুটো পুড়িয়ে ফেলা\n" +
                    "» রোগমুক্ত এলাকা হতে বীজ সংগ্রহ করা\n" +
                    "» ব্যাভিস্টিন দ্বারা বীজ শোধন করা (প্রতি কেজি বীজে ৩ গ্রাম ব্যাভিস্টিন উষধ ভালভাবে মিশানো অথবা ১ লিটার পানিতে ৩ গ্রাম ব্যাভিস্টিন মিশিয়ে তাতে ধানের বীজ সারারাত ভিজিয়ে রাখা\n" +
                    "» বীজতলা সবসময় পানি দিয়ে ভিজিয়ে রাখা\n" +
                    "» একই জমি বার বার বীজতলা হিসাবে ব্যবহার না করা");
            Glide.with(this).load(R.drawable.bakani).into(img1);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(DetailsActivity.this, DiseaseActivity.class);
        startActivity(intent);
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(DetailsActivity.this, DiseaseActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
