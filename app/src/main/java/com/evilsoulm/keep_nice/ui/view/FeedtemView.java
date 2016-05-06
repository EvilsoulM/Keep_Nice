package com.evilsoulm.keep_nice.ui.view;

import android.content.Context;
import android.widget.TextView;

import com.evilsoulm.keep_nice.R;
import com.evilsoulm.keep_nice.common.base.BaseAdapterItemView;
import com.evilsoulm.keep_nice.common.qualifier.ClickType;
import com.evilsoulm.keep_nice.model.dao.entity.Feed;
import com.evilsoulm.keep_nice.ui.view.component.RemoteImageView;

import butterknife.Bind;
import cn.bingoogolapple.badgeview.BGABadgeRelativeLayout;

public class FeedtemView extends BaseAdapterItemView<Feed> {
    @Bind(R.id.bga_rlyt_content)
    BGABadgeRelativeLayout topicContentView;

    @Bind(R.id.tv_title)
    TextView titleView;

    @Bind(R.id.avatar)
    RemoteImageView avatarView;

    @Bind(R.id.tv_description)
    TextView descriptionView;

    public FeedtemView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.feed_item;
    }

    @Override
    public void bind(Feed feed) {
//        if (!TextUtils.isEmpty(news.getImage())) {
//            Uri avatarUri = Uri.parse((news.getImage()));
//            avatarView.setUri(avatarUri);
//        }

        topicContentView.showTextBadge("0");
        titleView.setText(feed.getDesc());

        descriptionView.setText(feed.getDesc());

        topicContentView.setOnClickListener(v -> notifyItemAction(ClickType.CLICK_TYPE_TOPIC_CLICKED));

        avatarView.setOnClickListener(v -> notifyItemAction(ClickType.CLICK_TYPE_USER_CLICKED));
    }
}
