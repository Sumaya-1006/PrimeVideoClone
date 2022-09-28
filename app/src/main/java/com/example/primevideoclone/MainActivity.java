package com.example.primevideoclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.primevideoclone.adapter.BannerMoviesPagerAdapter;
import com.example.primevideoclone.adapter.MainRecyclerAdapter;
import com.example.primevideoclone.model.AllCategory;
import com.example.primevideoclone.model.BannerMovies;
import com.example.primevideoclone.model.CategoryItem;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout tabIndicator, categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvShowsBannerList = new ArrayList<>();
    List<BannerMovies> moviesBannerList;
    Timer sliderTimer;
    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    RecyclerView.LayoutManager layoutManager;
    List<AllCategory> allCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabIndicator = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);
        nestedScrollView = findViewById(R.id.nested_Scroll);
        appBarLayout = findViewById(R.id.appbar);

        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1,"The Hero","https://www.wallpaperuse.com/wallp/59-596880_m.jpg",""));
        homeBannerList.add(new BannerMovies(2,"The Hero","https://www.wallpaperuse.com/wallp/59-596880_m.jpg",""));
        homeBannerList.add(new BannerMovies(3,"The Hero","https://www.wallpaperuse.com/wallp/59-596880_m.jpg",""));
        homeBannerList.add(new BannerMovies(4,"The Hero","https://www.wallpaperuse.com/wallp/59-596880_m.jpg",""));
        homeBannerList.add(new BannerMovies(5,"The Hero","https://www.wallpaperuse.com/wallp/59-596880_m.jpg",""));


        tvShowsBannerList.add(new BannerMovies(1,"prathool","https://webneel.com/daily/sites/default/files/images/daily/01-2019/11-movie-poster-design-indian-tamil-8thottakkal-prathoolnt.jpg",""));
        tvShowsBannerList.add(new BannerMovies(2,"Prathool","https://webneel.com/daily/sites/default/files/images/daily/01-2019/11-movie-poster-design-indian-tamil-8thottakkal-prathoolnt.jpg",""));
        tvShowsBannerList.add(new BannerMovies(3,"Prathool","https://webneel.com/daily/sites/default/files/images/daily/01-2019/11-movie-poster-design-indian-tamil-8thottakkal-prathoolnt.jpg",""));
        tvShowsBannerList.add(new BannerMovies(4,"Prathool","https://webneel.com/daily/sites/default/files/images/daily/01-2019/11-movie-poster-design-indian-tamil-8thottakkal-prathoolnt.jpg",""));
        tvShowsBannerList.add(new BannerMovies(5,"Prathool","https://webneel.com/daily/sites/default/files/images/daily/01-2019/11-movie-poster-design-indian-tamil-8thottakkal-prathoolnt.jpg",""));

        moviesBannerList = new ArrayList<>();
        moviesBannerList.add(new BannerMovies(1,"Kanbadhu Poi","https://webneel.com/daily/sites/default/files/images/daily/01-2019/6-movie-poster-design-kollywood-tamil-imaikanodigal-prathoolnt.jpg",""));
        moviesBannerList.add(new BannerMovies(2,"Kanbadhu Poi","https://webneel.com/daily/sites/default/files/images/daily/01-2019/6-movie-poster-design-kollywood-tamil-imaikanodigal-prathoolnt.jpg",""));
        moviesBannerList.add(new BannerMovies(3,"Kanbadhu Poi","https://webneel.com/daily/sites/default/files/images/daily/01-2019/6-movie-poster-design-kollywood-tamil-imaikanodigal-prathoolnt.jpg",""));
        moviesBannerList.add(new BannerMovies(4,"Kanbadhu Poi","https://webneel.com/daily/sites/default/files/images/daily/01-2019/6-movie-poster-design-kollywood-tamil-imaikanodigal-prathoolnt.jpg",""));
        moviesBannerList.add(new BannerMovies(5,"Kanbadhu Poi","https://webneel.com/daily/sites/default/files/images/daily/01-2019/6-movie-poster-design-kollywood-tamil-imaikanodigal-prathoolnt.jpg",""));

        // this is default tab selected
        setBannerMoviesPagerAdapter(homeBannerList);

        // on tab change selected data
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(tvShowsBannerList);
                        break;

                        case 2:
                            setScrollDefaultState();
                            setBannerMoviesPagerAdapter(moviesBannerList);
                        break;
                    default:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(homeBannerList);

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //first add catItem data

        List<CategoryItem> homeCatListItem1 = new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1,"Pushpa","https://timesofindia.indiatimes.com/thumb/msid-88811784,width-1200,height-900,resizemode-4/.jpg",""));
        homeCatListItem1.add(new CategoryItem(2,"KGF","https://examresultbd.com/wp-content/uploads/2022/04/kgf-2-pictures.webp",""));
        homeCatListItem1.add(new CategoryItem(3,"Gabbar","https://wallpapercave.com/wp/wp8807393.jpg",""));
        homeCatListItem1.add(new CategoryItem(4,"Mejor","https://vijaysolution.com/wp-content/uploads/2022/06/Major-Movie-Download-Filmyzilla-Review-480p-720p-1080p.jpg",""));
        homeCatListItem1.add(new CategoryItem(5,"Brothers","https://wallpapercave.com/wp/wp7968119.jpg",""));

        List<CategoryItem> homeCatListItem2 = new ArrayList<>();
        homeCatListItem2.add(new CategoryItem(1,"Pushpa","https://timesofindia.indiatimes.com/thumb/msid-88811784,width-1200,height-900,resizemode-4/.jpg",""));
        homeCatListItem2.add(new CategoryItem(2,"KGF","https://examresultbd.com/wp-content/uploads/2022/04/kgf-2-pictures.webp",""));
        homeCatListItem2.add(new CategoryItem(3,"Gabbar","https://wallpapercave.com/wp/wp8807393.jpg",""));
        homeCatListItem2.add(new CategoryItem(4,"Mejor","https://vijaysolution.com/wp-content/uploads/2022/06/Major-Movie-Download-Filmyzilla-Review-480p-720p-1080p.jpg",""));
        homeCatListItem2.add(new CategoryItem(5,"Brothers","https://wallpapercave.com/wp/wp7968119.jpg",""));

        List<CategoryItem> homeCatListItem3 = new ArrayList<>();
        homeCatListItem3.add(new CategoryItem(1,"Pushpa","https://timesofindia.indiatimes.com/thumb/msid-88811784,width-1200,height-900,resizemode-4/.jpg",""));
        homeCatListItem3.add(new CategoryItem(2,"KGF","https://examresultbd.com/wp-content/uploads/2022/04/kgf-2-pictures.webp",""));
        homeCatListItem3.add(new CategoryItem(3,"Gabbar","https://wallpapercave.com/wp/wp8807393.jpg",""));
        homeCatListItem3.add(new CategoryItem(4,"Mejor","https://vijaysolution.com/wp-content/uploads/2022/06/Major-Movie-Download-Filmyzilla-Review-480p-720p-1080p.jpg",""));
        homeCatListItem3.add(new CategoryItem(5,"Brother","https://wallpapercave.com/wp/wp7968119.jpg",""));

        List<CategoryItem> homeCatListItem4 = new ArrayList<>();
        homeCatListItem4.add(new CategoryItem(1,"Pushpa","https://timesofindia.indiatimes.com/thumb/msid-88811784,width-1200,height-900,resizemode-4/.jpg",""));
        homeCatListItem4.add(new CategoryItem(2,"KGF","https://examresultbd.com/wp-content/uploads/2022/04/kgf-2-pictures.webp",""));
        homeCatListItem4.add(new CategoryItem(3,"Gabbar","https://wallpapercave.com/wp/wp8807393.jpg",""));
        homeCatListItem4.add(new CategoryItem(4,"Mejor","https://vijaysolution.com/wp-content/uploads/2022/06/Major-Movie-Download-Filmyzilla-Review-480p-720p-1080p.jpg",""));
        homeCatListItem4.add(new CategoryItem(5,"Brother","https://wallpapercave.com/wp/wp7968119.jpg",""));

        List<CategoryItem> homeCatListItem5 = new ArrayList<>();
        homeCatListItem5.add(new CategoryItem(1,"Pushpa","https://timesofindia.indiatimes.com/thumb/msid-88811784,width-1200,height-900,resizemode-4/.jpg",""));
        homeCatListItem5.add(new CategoryItem(2,"KGF","https://examresultbd.com/wp-content/uploads/2022/04/kgf-2-pictures.webp",""));
        homeCatListItem5.add(new CategoryItem(3,"Gabbar","https://wallpapercave.com/wp/wp8807393.jpg",""));
        homeCatListItem5.add(new CategoryItem(4,"Mejor","https://vijaysolution.com/wp-content/uploads/2022/06/Major-Movie-Download-Filmyzilla-Review-480p-720p-1080p.jpg",""));
        homeCatListItem5.add(new CategoryItem(5,"Brother","https://wallpapercave.com/wp/wp7968119.jpg",""));

        List<CategoryItem> homeCatListItem6 = new ArrayList<>();
        homeCatListItem6.add(new CategoryItem(1,"Pushpa","https://timesofindia.indiatimes.com/thumb/msid-88811784,width-1200,height-900,resizemode-4/.jpg",""));
        homeCatListItem6.add(new CategoryItem(2,"KGF","https://examresultbd.com/wp-content/uploads/2022/04/kgf-2-pictures.webp",""));
        homeCatListItem6.add(new CategoryItem(3,"Gabbar","https://wallpapercave.com/wp/wp8807393.jpg",""));
        homeCatListItem6.add(new CategoryItem(4,"Mejor","https://vijaysolution.com/wp-content/uploads/2022/06/Major-Movie-Download-Filmyzilla-Review-480p-720p-1080p.jpg",""));
        homeCatListItem6.add(new CategoryItem(5,"Brother","https://wallpapercave.com/wp/wp7968119.jpg",""));

        List<CategoryItem> homeCatListItem7 = new ArrayList<>();
        homeCatListItem7.add(new CategoryItem(1,"Pushpa","https://timesofindia.indiatimes.com/thumb/msid-88811784,width-1200,height-900,resizemode-4/.jpg",""));
        homeCatListItem7.add(new CategoryItem(2,"KGF","https://examresultbd.com/wp-content/uploads/2022/04/kgf-2-pictures.webp",""));
        homeCatListItem7.add(new CategoryItem(3,"Gabbar","https://wallpapercave.com/wp/wp8807393.jpg",""));
        homeCatListItem7.add(new CategoryItem(4,"Mejor","https://vijaysolution.com/wp-content/uploads/2022/06/Major-Movie-Download-Filmyzilla-Review-480p-720p-1080p.jpg",""));
        homeCatListItem7.add(new CategoryItem(5,"Brother","https://wallpapercave.com/wp/wp7968119.jpg",""));



        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Trending",homeCatListItem1));
        allCategoryList.add(new AllCategory(2,"Dramas on Sale",homeCatListItem2));
        allCategoryList.add(new AllCategory(3,"Most Popular",homeCatListItem3));
        allCategoryList.add(new AllCategory(4,"Bangladeshi",homeCatListItem4));
        allCategoryList.add(new AllCategory(5,"Korean",homeCatListItem5));
        allCategoryList.add(new AllCategory(6,"Bangla Dubbing",homeCatListItem6));
        allCategoryList.add(new AllCategory(7,"English",homeCatListItem7));



        //setup method
        setMainRecycler(allCategoryList);
    }

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList){

        bannerMoviesViewPager = findViewById(R.id.banner_view);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this,bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        tabIndicator.setupWithViewPager(bannerMoviesViewPager);

        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(),4000,6000);
        tabIndicator.setupWithViewPager(bannerMoviesViewPager,true);

    }
    class AutoSlider extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(bannerMoviesViewPager.getCurrentItem() < homeBannerList.size() - 1){
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);

                    }else{
                        bannerMoviesViewPager.setCurrentItem(0);
                }

                }
            });

        }
    }
    public void setMainRecycler(List<AllCategory> allCategoryList){

        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this,allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);

    }
    //set full scroll
    private void setScrollDefaultState() {
         nestedScrollView.fullScroll(View.FOCUS_UP) ;
         nestedScrollView.scrollTo(0,0);
         appBarLayout.setExpanded(true);
    }

}