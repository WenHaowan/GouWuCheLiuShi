package as.bwei.com.gouwucheliushi.view;

import as.bwei.com.gouwucheliushi.bean.CartBean;

/**
 * Created by HP on 2018/9/23.
 */

public interface IcartView {
    void success(CartBean cartBean);
    void failure(String msg);
}
