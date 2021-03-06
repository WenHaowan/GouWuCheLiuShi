package as.bwei.com.gouwucheliushi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import as.bwei.com.gouwucheliushi.R;
import as.bwei.com.gouwucheliushi.bean.CartBean;
import as.bwei.com.gouwucheliushi.widget.MyJIaJianView;

/**
 * Created by HP on 2018/9/23.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.CartViewHolder>{
    private Context mContext;
    private List<CartBean.DataBean.ListBean> listBeanList;

    public ProductAdapter(Context mContext, List<CartBean.DataBean.ListBean> listBeanList) {
        this.mContext = mContext;
        this.listBeanList = listBeanList;
    }

    @Override
    public ProductAdapter.CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.product_item_layout,parent,false);
        CartViewHolder viewHolder = new CartViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductAdapter.CartViewHolder holder, int position) {
        final CartBean.DataBean.ListBean bean = listBeanList.get(position);

        holder.priceTv.setText("优惠价：¥" + bean.getBargainPrice());
        holder.titleTv.setText(bean.getTitle());
        String[] imgs = bean.getImages().split("\\|");

        if (imgs!=null && imgs.length>0){
            Glide.with(mContext).load(imgs[0]).into(holder.productIv);
        }else {
            holder.productIv.setImageResource(R.mipmap.ic_launcher);
        }

        holder.myJIaJianView.setNumEt(bean.getTotalNum());
    }

    @Override
    public int getItemCount() {
        return listBeanList.size() == 0 ? 0 : listBeanList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTv, priceTv;
        private ImageView productIv;
        private MyJIaJianView myJIaJianView;

        public CartViewHolder(View itemView) {
            super(itemView);

            titleTv = (TextView) itemView.findViewById(R.id.title);
            priceTv = (TextView) itemView.findViewById(R.id.price);
            productIv = (ImageView) itemView.findViewById(R.id.product_icon);
            myJIaJianView = (MyJIaJianView) itemView.findViewById(R.id.jiajianqi);

        }
    }
}
