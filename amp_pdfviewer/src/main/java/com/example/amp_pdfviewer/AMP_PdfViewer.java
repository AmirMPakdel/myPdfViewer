package com.example.amp_pdfviewer;

import android.content.Context;
import android.util.AttributeSet;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.HashMap;
import java.util.Map;

public class AMP_PdfViewer {


    private PDFView pdfView;

    public AMP_PdfViewer(Context context){

        pdfView = new PDFView(context, getAttributeSet());
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



    private AttributeSet getAttributeSet(){

        final int count = 0;
        final Map<String, String> attrs = new HashMap<>();

        return new AttributeSet() {
            @Override
            public int getAttributeCount() {
                return count;
            }

            @Override
            public String getAttributeName(int index) {
                return attrs.get();
            }

            @Override
            public String getAttributeValue(int index) {
                return null;
            }

            @Override
            public String getAttributeValue(String namespace, String name) {
                return null;
            }

            @Override
            public String getPositionDescription() {
                return null;
            }

            @Override
            public int getAttributeNameResource(int index) {
                return 0;
            }

            @Override
            public int getAttributeListValue(String namespace, String attribute, String[] options, int defaultValue) {
                return 0;
            }

            @Override
            public boolean getAttributeBooleanValue(String namespace, String attribute, boolean defaultValue) {
                return false;
            }

            @Override
            public int getAttributeResourceValue(String namespace, String attribute, int defaultValue) {
                return 0;
            }

            @Override
            public int getAttributeIntValue(String namespace, String attribute, int defaultValue) {
                return 0;
            }

            @Override
            public int getAttributeUnsignedIntValue(String namespace, String attribute, int defaultValue) {
                return 0;
            }

            @Override
            public float getAttributeFloatValue(String namespace, String attribute, float defaultValue) {
                return 0;
            }

            @Override
            public int getAttributeListValue(int index, String[] options, int defaultValue) {
                return 0;
            }

            @Override
            public boolean getAttributeBooleanValue(int index, boolean defaultValue) {
                return false;
            }

            @Override
            public int getAttributeResourceValue(int index, int defaultValue) {
                return 0;
            }

            @Override
            public int getAttributeIntValue(int index, int defaultValue) {
                return 0;
            }

            @Override
            public int getAttributeUnsignedIntValue(int index, int defaultValue) {
                return 0;
            }

            @Override
            public float getAttributeFloatValue(int index, float defaultValue) {
                return 0;
            }

            @Override
            public String getIdAttribute() {
                return null;
            }

            @Override
            public String getClassAttribute() {
                return null;
            }

            @Override
            public int getIdAttributeResourceValue(int defaultValue) {
                return 0;
            }

            @Override
            public int getStyleAttribute() {
                return 0;
            }
        };
    }


}
