package pdf.dudepdftools.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import pdf.dudepdftools.R;
import pdf.dudepdftools.activity.MainActivity;
import pdf.dudepdftools.adapter.RecentListAdapter;
import pdf.dudepdftools.customviews.MyCardView;
import pdf.dudepdftools.fragment.texttopdf.TextToPdfFragment;
import pdf.dudepdftools.model.HomePageItem;
import pdf.dudepdftools.util.AdLoader;
import pdf.dudepdftools.util.CommonCodeUtils;
import pdf.dudepdftools.util.RecentUtil;

import static pdf.dudepdftools.util.Constants.ADD_IMAGES;
import static pdf.dudepdftools.util.Constants.ADD_PWD;
import static pdf.dudepdftools.util.Constants.ADD_WATERMARK;
import static pdf.dudepdftools.util.Constants.BUNDLE_DATA;
import static pdf.dudepdftools.util.Constants.COMPRESS_PDF;
import static pdf.dudepdftools.util.Constants.EXTRACT_IMAGES;
import static pdf.dudepdftools.util.Constants.PDF_TO_IMAGES;
import static pdf.dudepdftools.util.Constants.REMOVE_PAGES;
import static pdf.dudepdftools.util.Constants.REMOVE_PWd;
import static pdf.dudepdftools.util.Constants.REORDER_PAGES;
import static pdf.dudepdftools.util.Constants.ROTATE_PAGES;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    @BindView(R.id.images_to_pdf)
    MyCardView imagesToPdf;
//    @BindView(R.id.qr_barcode_to_pdf)
//    MyCardView qrbarcodeToPdf;
    @BindView(R.id.text_to_pdf)
    MyCardView textToPdf;
    @BindView(R.id.view_files)
    MyCardView viewFiles;
//    @BindView(R.id.view_history)
//    MyCardView viewHistory;
    @BindView(R.id.split_pdf)
    MyCardView splitPdf;
    @BindView(R.id.merge_pdf)
    MyCardView mergePdf;
//    @BindView(R.id.compress_pdf)
//    MyCardView compressPdf;
    @BindView(R.id.remove_pages)
    MyCardView removePages;
    @BindView(R.id.rearrange_pages)
    MyCardView rearrangePages;
    @BindView(R.id.extract_images)
    MyCardView extractImages;
    @BindView(R.id.pdf_to_images)
    MyCardView mPdfToImages;
    @BindView(R.id.add_password)
    MyCardView addPassword;
    @BindView(R.id.remove_password)
    MyCardView removePassword;
    @BindView(R.id.rotate_pages)
    MyCardView rotatePdf;
    @BindView(R.id.add_watermark)
    MyCardView addWatermark;
    @BindView(R.id.add_images)
    MyCardView addImages;
//    @BindView(R.id.remove_duplicates_pages_pdf)
//    MyCardView removeDuplicatePages;
//    @BindView(R.id.invert_pdf)
//    MyCardView invertPdf;
//    @BindView(R.id.zip_to_pdf)
//    MyCardView zipToPdf;
//    @BindView(R.id.excel_to_pdf)
//    MyCardView excelToPdf;
    @BindView(R.id.extract_text)
    MyCardView extractText;
    @BindView(R.id.add_text)
    MyCardView addText;

//    @BindView(R.id.recent_list)
//    RecyclerView recentList;

//    @BindView(R.id.recent_lbl)
//    View recentLabel;

//    @BindView(R.id.recent_list_lay)
//    ViewGroup recentLayout;

    private Map<Integer, HomePageItem> mFragmentPositionMap;
    private RecentListAdapter mAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_home_, container, false);
        ButterKnife.bind(this, rootview);
        mFragmentPositionMap = CommonCodeUtils.getInstance().fillNavigationItemsMap(true);


        imagesToPdf.setOnClickListener(this);
//        qrbarcodeToPdf.setOnClickListener(this);
        textToPdf.setOnClickListener(this);
        viewFiles.setOnClickListener(this);
//        viewHistory.setOnClickListener(this);
        splitPdf.setOnClickListener(this);
        mergePdf.setOnClickListener(this);
//        compressPdf.setOnClickListener(this);
        removePages.setOnClickListener(this);
        rearrangePages.setOnClickListener(this);
        extractImages.setOnClickListener(this);
        mPdfToImages.setOnClickListener(this);
        addPassword.setOnClickListener(this);
        removePassword.setOnClickListener(this);
        rotatePdf.setOnClickListener(this);
        addWatermark.setOnClickListener(this);
        addImages.setOnClickListener(this);
//        removeDuplicatePages.setOnClickListener(this);
//        invertPdf.setOnClickListener(this);
//        zipToPdf.setOnClickListener(this);
//        excelToPdf.setOnClickListener(this);
        extractText.setOnClickListener(this);
        addText.setOnClickListener(this);

//        mAdapter =  new RecentListAdapter(this);
//        recentList.setAdapter(mAdapter);

        return rootview;
    }

    @Override public void onViewCreated(
            @NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        try {
//            LinkedHashMap<String, Map<String, String>> mRecentList = RecentUtil.getInstance()
//                    .getList(PreferenceManager.getDefaultSharedPreferences(mActivity));
//            if (!mRecentList.isEmpty()) {
//                recentLabel.setVisibility(View.VISIBLE);
//                recentLayout.setVisibility(View.VISIBLE);
//                List<String> featureItemIds = new ArrayList<>(mRecentList.keySet());
//                List<Map<String, String>> featureItemList = new ArrayList<>(mRecentList.values());
//                mAdapter.updateList(featureItemIds, featureItemList);
//                mAdapter.notifyDataSetChanged();
//            } else {
//                recentLabel.setVisibility(View.GONE);
//                recentLayout.setVisibility(View.GONE);
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Override
    public void onClick(View v) {

        Fragment fragment = null;
        FragmentManager fragmentManager = getFragmentManager();
        Bundle bundle = new Bundle();

        highlightNavigationDrawerItem(mFragmentPositionMap.get(v.getId()).getNavigationItemId());
        setTitleFragment(mFragmentPositionMap.get(v.getId()).getTitleString());

        Map<String, String> feature = new HashMap<>();
        feature.put(
                String.valueOf(mFragmentPositionMap.get(v.getId()).getTitleString()),
                String.valueOf(mFragmentPositionMap.get(v.getId()).getmDrawableId()));

        try {
            RecentUtil.getInstance().addFeatureInRecentList(PreferenceManager
                    .getDefaultSharedPreferences(mActivity), v.getId(), feature);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        switch (v.getId()) {
            case R.id.images_to_pdf:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new ImageToPdfFragment();
                break;
//            case R.id.qr_barcode_to_pdf:
//                AdLoader.getAds().showFBFirst(mActivity);
//                fragment = new QrBarcodeScanFragment();
//                break;
            case R.id.text_to_pdf:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new TextToPdfFragment();
                break;
            case R.id.view_files:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new ViewFilesFragment();
                break;
//            case R.id.view_history:
//                AdLoader.getAds().showFBFirst(mActivity);
//                fragment = new HistoryFragment();
//                break;
            case R.id.merge_pdf:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new MergeFilesFragment();
                break;
            case R.id.split_pdf:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new SplitFilesFragment();
                break;
//            case R.id.compress_pdf:
//                AdLoader.getAds().showFBFirst(mActivity);
//                fragment = new RemovePagesFragment();
//                bundle.putString(BUNDLE_DATA, COMPRESS_PDF);
//                fragment.setArguments(bundle);
//                break;
            case R.id.extract_images:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new PdfToImageFragment();
                bundle.putString(BUNDLE_DATA, EXTRACT_IMAGES);
                fragment.setArguments(bundle);
                break;
            case R.id.pdf_to_images:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new PdfToImageFragment();
                bundle.putString(BUNDLE_DATA, PDF_TO_IMAGES);
                fragment.setArguments(bundle);
                break;
            case R.id.remove_pages:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new RemovePagesFragment();
                bundle.putString(BUNDLE_DATA, REMOVE_PAGES);
                fragment.setArguments(bundle);
                break;
            case R.id.rearrange_pages:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new RemovePagesFragment();
                bundle.putString(BUNDLE_DATA, REORDER_PAGES);
                fragment.setArguments(bundle);
                break;
            case R.id.add_password:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new RemovePagesFragment();
                bundle.putString(BUNDLE_DATA, ADD_PWD);
                fragment.setArguments(bundle);
                break;
            case R.id.remove_password:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new RemovePagesFragment();
                bundle.putString(BUNDLE_DATA, REMOVE_PWd);
                fragment.setArguments(bundle);
                break;
            case R.id.rotate_pages:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new ViewFilesFragment();
                bundle.putInt(BUNDLE_DATA, ROTATE_PAGES);
                fragment.setArguments(bundle);
                break;
            case R.id.add_watermark:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new ViewFilesFragment();
                bundle.putInt(BUNDLE_DATA, ADD_WATERMARK);
                fragment.setArguments(bundle);
                break;
            case R.id.add_images:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new AddImagesFragment();
                bundle.putString(BUNDLE_DATA, ADD_IMAGES);
                fragment.setArguments(bundle);
                break;
//            case R.id.remove_duplicates_pages_pdf:
//                AdLoader.getAds().showFBFirst(mActivity);
//                fragment = new RemoveDuplicatePagesFragment();
//                break;
//            case R.id.invert_pdf:
//                AdLoader.getAds().showFBFirst(mActivity);
//                fragment = new InvertPdfFragment();
//                break;
            case R.id.zip_to_pdf:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new ZipToPdfFragment();
                break;
//            case R.id.excel_to_pdf:
//                AdLoader.getAds().showFBFirst(mActivity);
//                fragment = new ExceltoPdfFragment();
//                break;
            case R.id.extract_text:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new ExtractTextFragment();
                break;
            case R.id.add_text:
                AdLoader.getAds().showFBFirst(mActivity);
                fragment = new AddTextFragment();
                break;
        }

        try {
            if (fragment != null && fragmentManager != null)
                fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Highligh navigation drawer item
     * @param id - item id to be hjighlighted
     */
    private void highlightNavigationDrawerItem(int id) {
        if (mActivity instanceof MainActivity)
            ((MainActivity) mActivity).setNavigationViewSelection(id);
    }

    /**
     * Sets the title on action bar
     * @param title - title of string to be shown
     */
    private void setTitleFragment(int title) {
        if (title != 0)
            mActivity.setTitle(title);
    }
}
