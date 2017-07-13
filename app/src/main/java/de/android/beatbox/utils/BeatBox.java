package de.android.beatbox.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final String TAG = "BeatBox";
    public static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager assets;
    private List<Sound> sounds = new ArrayList<>();

    public BeatBox(Context context) {
        assets = context.getAssets();
        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames;
        try {
            soundNames = assets.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found " + soundNames.length + " sounds");
        }catch (IOException e) {
            Log.e(TAG, "Could not list assets", e);
            return;
        }

        for (String filename : soundNames) {
            String assetPath = SOUNDS_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);
            sounds.add(sound);
        }
    }

    public List<Sound> getSounds() {
        return sounds;
    }
}
