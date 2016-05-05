package com.evilsoulm.keep_nice.ui.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;

import com.evilsoulm.keep_nice.R;
import com.evilsoulm.keep_nice.common.base.BaseAdapterItemView;
import com.evilsoulm.keep_nice.common.qualifier.ClickType;
import com.evilsoulm.keep_nice.model.dao.entity.News;
import com.evilsoulm.keep_nice.ui.view.component.RemoteImageView;

import butterknife.Bind;
import cn.bingoogolapple.badgeview.BGABadgeRelativeLayout;

public class TopicItemView extends BaseAdapterItemView<News> {
    @Bind(R.id.bga_rlyt_content)
    BGABadgeRelativeLayout topicContentView;

    @Bind(R.id.tv_title)
    TextView titleView;

    @Bind(R.id.avatar)
    RemoteImageView avatarView;

    @Bind(R.id.tv_description)
    TextView descriptionView;

    public TopicItemView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.topic_item;
    }

    @Override
    public void bind(News news) {
        if (!TextUtils.isEmpty(news.getImage())) {
            Uri avatarUri = Uri.parse((news.getImage()));
            avatarView.setUri(avatarUri);
        }

        topicContentView.showTextBadge("0");
        titleView.setText(news.getTitle());

        descriptionView.setText(news.getGa_prefix());

        topicContentView.setOnClickListener(v -> notifyItemAction(ClickType.CLICK_TYPE_TOPIC_CLICKED));

        avatarView.setOnClickListener(v -> notifyItemAction(ClickType.CLICK_TYPE_USER_CLICKED));
    }
}
