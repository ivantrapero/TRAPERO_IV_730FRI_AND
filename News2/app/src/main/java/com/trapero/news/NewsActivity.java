package com.trapero.news;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    private ListView newsListView;
    private ArrayList<NewsItem> newsList;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Ensure this is the correct layout containing the ListView

        // Find ListView by its ID
        newsListView = findViewById(R.id.news_listview);

        // Populate the list with news items (title, description, image resource)
        newsList = new ArrayList<>();
        newsList.add(new NewsItem("Signal no. 1 up in Batanes as Typhoon Julian re-enters PAR", "Under Signal No. 1, winds of 39-61 km/h may be expected in at least 36 hours or intermittent rains may be expected within 36 hours, PAGASA said.\n" +
                "\n" +
                "Further, local winds may be slightly stronger or enhanced in coastal and upland or mountainous areas exposed to winds, while winds are weaker in areas sheltered from the prevailing wind direction.\n" +
                "\n" +
                "Minimal to minor impacts from strong winds are possible within any of the areas under Wind Signal No. 1, PAGASA said.\"Despite its re-entry in the PAR region, no direct effect is anticipated over the country except for Batanes, which is relatively close to Taiwan,\" PAGASA added.\n" +
                "\n" +
                "Moving East Northeastward, the tropical cyclone has maximum sustained winds of 120 km/h near the center and gustiness of up to 165 km/h.\n" +
                "\n" +
                "The center of the eye was estimated based on all available data 245 km Northwest of Itbayat, Batanes (22.4 °N, 120.2 °E ).\n" +
                "\n" +
                "According to the National Disaster Risk Reduction and Management Council (NDRRMC) on Thursday, two people were reported killed while eight were injured due to the heavy rains and strong winds caused by Typhoon Julian.\n" +
                "\n" +
                "In its 8 a.m. situational report, the NDRRMC said the reported fatalities were one individual from Region 1 (Ilocos Region) and one from the Cordillera Administrative Region (CAR).\n" +
                "\n" +
                "The eight injured persons were from Region 2 (Cagayan Valley). One person was also confirmed missing because of Julian. —VAL/KBK, GMA Integrated News", R.drawable.typhoon));

        newsList.add(new NewsItem("Lanao del Sur's largest political bloc first to file COCs in BARMM", "COTABATO CITY — The largest regional political party in the Bangsamoro region hit the news after all of its members in Lanao del Sur aspiring for various elective posts in the province assembled and filed their certificates of candidacy in Marawi City on Tuesday morning, October 1.\n" +
                "\n" +
                "The members of the Serbisyong Inklusibo, Alyansang Progresibo (SIAP) Party in Lanao del Sur, led by the reelectionists Lanao del Sur Gov. Mamintal Alonto Adiong Jr. and Vice Gov. Muhammad Khalid Rakiin Adiong, arrived at the public gymnasium in Marawi City to submit their certificates of candidacy together on Tuesday morning, something never witnessed before by the predominantly Maranao communities in the province.\n" +
                "\n" +
                "Politicians in BARMM are known for their practice of filing COCs in either the middle part or the last day of the period of such an activity.\n" +
                "\n" +
                "Radio reports in Cotabato City and in provinces of the Bangsamoro region on Wednesday stated that provincial officials of the Commission on Elections in Lanao del Sur set up a COC filing center at a public gymnasium in Marawi City, which virtually turned quiet after Adiong and other members of SIAP Party had left.\n" +
                "\n" +
                "The SIAP Party is the pioneer and oldest regional political party in the Bangsamoro Autonomous Region in Muslim Mindanao, which covers the provinces of Maguindanao del Sur, Maguindanao del Norte, Lanao del Sur, Basilan and Tawi-Tawi and the cities of Lamitan, Cotabato and Marawi.\n" +
                "\n" +
                "Two members of the SIAP Party, Congressmen Zia-ur Rahman Alonto Adiong and Yasser Alonto Balindong of the first and second congressional districts in Lanao del Sur, respectively, are also seeking reelection. \n" +
                "\n" +
                "The SIAP Party, which has peace and security initiatives and community-empowerment programs focused on promotion of religious and cultural solidarity among BARMM’s Muslim, Christian and indigenous non-Moro groups, has more than 700,000 documented members in the autonomous region. The party also has socio-economic projects meant to boost regional commerce and trade to generate employment for BARMM's marginalized residents.\n" +
                "\n" +
                "Adiong, who is seeking a second term as Lanao del Sur provincial governor, told reporters that all candidates of SIAP are ready to swear over the Qur’an to abide with the Omnibus Election Code and help the police, the military and the Commission on Elections ensure a peaceful electoral exercise in the province in May 2025.\n" +
                "\n", R.drawable.lanao));

        newsList.add(new NewsItem("LIST: Senatorial aspirants for Eleksyon 2025", "The filing of certificates of candidacy (COCs) for the 2025 midterm polls is from Oct. 1 to 8, seven months before the May 2025 elections.\n" +
                "\n" +
                "Based on records of the Commission on Elections (Comelec), here are the individuals who filed their COC for senator, in chronological order:, The term of office for senators is six years. No senator, however, is allowed to serve for more than two consecutive terms.\n" +
                "\n" +
                "The Constitution also provides that voluntary renunciation of the office for any length of time \"will not be considered as an interruption in the continuity of his service for the full term for which he was elected.\" — Llanesca T. Panti/VDV/KBK, GMA Integrated News", R.drawable.nle));

        // Set up the adapter and attach it to the ListView
        newsAdapter = new NewsAdapter(this, newsList);
        newsListView.setAdapter(newsAdapter);
    }
}
