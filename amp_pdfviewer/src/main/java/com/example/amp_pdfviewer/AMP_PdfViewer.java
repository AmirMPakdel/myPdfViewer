package com.example.amp_pdfviewer;

import android.content.Context;
import android.widget.EditText;
import android.widget.SeekBar;

import com.github.barteksc.pdfviewer.PDFView;

public class AMP_PdfViewer {


    private PDFView pdfView;

    int pageCount = 3;

    int currentPage;

    public AMP_PdfViewer(Context context, PDFView pdfView){

        this.pdfView = pdfView;
    }

    public void loadPdf(byte[] bytes){

        pdfView.fromBytes(bytes)
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                // allows to draw something on the current page, usually visible in the middle of the screen
                //        .onDraw(onDrawListener)
                // allows to draw something on all pages, separately for every page. Called only for visible pages
                //        .onDrawAll(onDrawListener)
                //        .onLoad(onLoadCompleteListener) // called after document is loaded and starts to be rendered
                //        .onPageChange(onPageChangeListener)
                //        .onPageScroll(onPageScrollListener)
                //        .onError(onErrorListener)
                //        .onPageError(onPageErrorListener)
                //        .onRender(onRenderListener) // called after document is rendered for the first time
                // called on single tap, return true if handled, false to toggle scroll handle visibility
                //        .onTap(onTapListener)
                //        .onLongPress(onLongPressListener)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                //        .autoSpacing(false) // add dynamic spacing to fit each page on its own on the screen
                //        .linkHandler(DefaultLinkHandler)
                //        .pageFitPolicy(FitPolicy.WIDTH)
                //        .pageSnap(true) // snap pages to screen boundaries
                //        .pageFling(false) // make a fling change only a single page like ViewPager
                //        .nightMode(false) // toggle night mode
                .load();

        pdfView.useBestQuality(true);

        pageCount = pdfView.getPageCount();

        currentPage = pdfView.getCurrentPage();
    }

    public void setPageController(EditText pageController){

        pageController.setText(currentPage+" / "+pageCount);

        pageController.clearFocus();

    }

    public void setZoomController(SeekBar zoombar){

        zoombar.setMax(30);

        zoombar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                progress += 10;

                pdfView.zoomWithAnimation(progress/10f);

                log.print("changed! : "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }

}
