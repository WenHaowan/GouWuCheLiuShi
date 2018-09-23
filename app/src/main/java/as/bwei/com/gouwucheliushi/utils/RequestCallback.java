package as.bwei.com.gouwucheliushi.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by HP on 2018/9/23.
 */

public interface RequestCallback {
    void failure(Call call, IOException e);
    void onResponse(Call call, Response response);
}
