package com.uuzuche.lib_zxing;

import android.hardware.Camera;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

/**
 * Created by user on 2017/8/2.
 */

public class ParametersTools {

    private Camera camera;
    private Button btnChange;
    private Button btnFocus;
    private Button btnFlash;
    private Button btnAntibanding;
    private Button btnWhite;
    private Button btnScene;
    private ScanTools scanTools;
    private Button btnZoom;
    private View view;
    //设置相机滤镜
    private void setColors(String value){

        Camera.Parameters parameters = camera.getParameters();

        //-------------------------模式----------------
        List<String> colorEffects = parameters.getSupportedColorEffects();//扫描滤镜
        String colorEffect = parameters.getColorEffect();
        parameters.setColorEffect(value);

        List<String> focusModes = parameters.getSupportedFocusModes();//扫描对焦
        String focusMode = parameters.getFocusMode();
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_INFINITY);
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_MACRO);
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_FIXED);
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_EDOF);
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);

        List<String> flashModes = parameters.getSupportedFlashModes();//闪光灯
        String flashMode = parameters.getFlashMode();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_AUTO);
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_ON);
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_RED_EYE);
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);


        List<String> sceneModes = parameters.getSupportedSceneModes();//获得支持的场景模式
        String sceneMode = parameters.getSceneMode();
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_ACTION);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_AUTO);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_BARCODE);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_BEACH);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_CANDLELIGHT);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_FIREWORKS);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_HDR);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_LANDSCAPE);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_NIGHT);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_NIGHT_PORTRAIT);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_PARTY);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_PORTRAIT);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_SNOW);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_SPORTS);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_STEADYPHOTO);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_SUNSET);
        parameters.setSceneMode(Camera.Parameters.SCENE_MODE_THEATRE);


        List<String> antibandings = parameters.getSupportedAntibanding();//获取支持的防牛顿环配置
        String antibanding = parameters.getAntibanding();
        parameters.setAntibanding(Camera.Parameters.ANTIBANDING_AUTO);
        parameters.setAntibanding(Camera.Parameters.ANTIBANDING_OFF);
        parameters.setAntibanding(Camera.Parameters.ANTIBANDING_50HZ);
        parameters.setAntibanding(Camera.Parameters.ANTIBANDING_60HZ);


        List<String> whiteBalances = parameters.getSupportedWhiteBalance();//获取当前支持的白平衡值
        String whiteBalance = parameters.getWhiteBalance();
        parameters.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_AUTO);
        parameters.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_CLOUDY_DAYLIGHT);
        parameters.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_DAYLIGHT);
        parameters.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_FLUORESCENT);
        parameters.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_INCANDESCENT);
        parameters.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_SHADE);
        parameters.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_TWILIGHT);
        parameters.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_WARM_FLUORESCENT);


        //-------------------------数量----------------
        List<Camera.Size> jpegThumbnailSizes = parameters.getSupportedJpegThumbnailSizes();
        Camera.Size jpegThumbnailSize = parameters.getJpegThumbnailSize();
        parameters.setJpegThumbnailQuality(0);
        parameters.setJpegThumbnailSize(0,0);


        List<Camera.Size> pictureSizes = parameters.getSupportedPictureSizes();
        Camera.Size pictureSize = parameters.getPictureSize();
        parameters.setPictureSize(0,0);


        List<Camera.Size> previewSizes = parameters.getSupportedPreviewSizes();
        Camera.Size previewSize = parameters.getPreviewSize();
        parameters.setPreviewSize(0,0);


        List<Camera.Size> videoSizes = parameters.getSupportedVideoSizes();
        Camera.Size preferredPreviewSizeForVideo = parameters.getPreferredPreviewSizeForVideo();


        //-------------------------Formats-----------
        List<Integer> pictureFormats = parameters.getSupportedPictureFormats();
        int pictureFormat = parameters.getPictureFormat();
        parameters.setPictureFormat(0);

        List<Integer> previewFormats = parameters.getSupportedPreviewFormats();
        int previewFormat = parameters.getPreviewFormat();
        parameters.setPreviewFormat(0);

        List<Integer> previewFrameRates = parameters.getSupportedPreviewFrameRates();
        int previewFrameRate = parameters.getPreviewFrameRate();
        parameters.setPreviewFrameRate(0);

        //-------------------------Formats-----------
        List<int[]> previewFpsRange = parameters.getSupportedPreviewFpsRange();
        parameters.getPreviewFpsRange(new int[]{});
        parameters.setPreviewFpsRange(0,0);

        //-------------------------设置给相机--------------------
        camera.setParameters(parameters);
    }


    private void change() {
        final Camera.Parameters parameters = camera.getParameters();
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanTools.changeEffect(btnChange);
            }
        });
        btnFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanTools.changeFocus(btnFocus);
            }
        });
        btnFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanTools.changeFlash(btnFlash);
            }
        });
        btnScene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanTools.changeScene(btnScene);

            }
        });
        btnAntibanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*parameters.setAntibanding(Camera.Parameters.ANTIBANDING_60HZ);
                camera.setParameters(parameters);*/
            }
        });
        btnWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanTools.changeWhite(btnWhite);
            }
        });
        btnZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int max = parameters.getMaxZoom();
                int zoom = parameters.getZoom();
                Log.v("tag", max+"-"+zoom);
                scanTools.changeZoom(btnZoom);
            }
        });

    }
}
