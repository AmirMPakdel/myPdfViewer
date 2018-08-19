package com.example.packdel.mypdfviewer;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.widget.EditText;
import android.widget.SeekBar;

import com.example.amp_pdfviewer.AMP_PdfViewer;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyAsyncTask extends AsyncTask {

    private Context context;

    private InputStream inputStream;

    ConstraintLayout layout;

    public MyAsyncTask(Context context, InputStream inputStream, ConstraintLayout layout){

        this.context = context;
        this.inputStream = inputStream;
        this.layout = layout;
    }

    @Override
    protected Object doInBackground(Object... objects) {

        try {

            ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

            // this is storage overwritten on each iteration with bytes
            int bufferSize = 1024;
            byte[] bytes = new byte[bufferSize];

            // we need to know how may bytes were read to write them to the byteBuffer
            int len = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                byteBuffer.write(bytes, 0, len);
            }

            // and then we can return your byte array.
            byte[] buffer =  byteBuffer.toByteArray();

            log.print("buffer is ready!");


            AMP_PdfViewer pdfViewer = new AMP_PdfViewer(context, (PDFView) layout.findViewById(R.id.pdfView));

            pdfViewer.loadPdf(buffer);

            log.print("finished!");

            pdfViewer.setZoomController((SeekBar) layout.findViewById(R.id.zoomBar));
            pdfViewer.setPageController((EditText) layout.findViewById(R.id.pageNumber));


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
