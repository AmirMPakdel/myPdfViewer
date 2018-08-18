package com.example.amp_pdfviewer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.HashMap;
import java.util.Map;

public class AMP_PdfViewer {


    private PDFView pdfView;

    public AMP_PdfViewer(Context context, PDFView v){

        pdfView = v;
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
    }
}
