package as.bwei.com.gouwucheliushi.presenter;

import java.util.HashMap;

import as.bwei.com.gouwucheliushi.bean.CartBean;
import as.bwei.com.gouwucheliushi.model.CartModel;
import as.bwei.com.gouwucheliushi.view.IcartView;

/**
 * Created by HP on 2018/9/23.
 */

public class CartPresenter {
    private CartModel cartModel;
    private IcartView icartView;

    public CartPresenter(IcartView icartView) {
        cartModel = new CartModel();
        attachView(icartView);
    }

    private void attachView(IcartView icartView) {
        this.icartView = icartView;
    }

    public void getCarts(HashMap<String,String> params, String url){
        cartModel.getCarts(params, url, new CartModel.CartCallback() {

            @Override
            public void success(CartBean cartBean) {
                if (icartView!=null){
                    icartView.success(cartBean);
                }
            }

            @Override
            public void fail(String msg) {
                if (icartView!=null){
                    icartView.failure(msg);
                }
            }
        });
    }
}
