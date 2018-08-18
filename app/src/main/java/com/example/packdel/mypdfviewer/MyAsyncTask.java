package com.example.packdel.mypdfviewer;

import android.content.Context;
import android.os.AsyncTask;

import com.example.amp_pdfviewer.AMP_PdfViewer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyAsyncTask extends AsyncTask {

    private Context context;

    private InputStream inputStream;

    public MyAsyncTask(Context context, InputStream inputStream){

        this.context = context;
        this.inputStream = inputStream;
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


            AMP_PdfViewer pdfViewer = new AMP_PdfViewer(context);

            pdfViewer.loadPdf(buffer);

            log.print("finished!");



        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
