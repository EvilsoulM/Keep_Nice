package com.evilsoulm.keep_nice.model.dao.entity;

import java.util.List;

/**
 * Author by mazixuan
 * Data:2016-05-05 15:13
 * Project:Keep_Nice
 * Detail:
 */
public class LastestNewsResponse {

    /**
     * date : 20160505
     * stories : [{"title":"这种酷炫狂拽的运动装备，完全满足了我的中二之心","ga_prefix":"050515","images":["http://pic2.zhimg.com/3736418541064d7b15f970540d4946c1.jpg"],"multipic":true,"type":0,"id":8254916},{"images":["http://pic2.zhimg.com/5b0e57e4a9ac617913a761291e8d61d1.jpg"],"type":0,"id":8259085,"ga_prefix":"050514","title":"登山的时候上厕所，面对的都是大好河山，不过剩下的\u2026\u2026"},{"title":"什么，这些云看着都一样？不不不，我来告诉你答案","ga_prefix":"050513","images":["http://pic2.zhimg.com/584401453a9e29cf2d534ab6c843d1e9.jpg"],"multipic":true,"type":0,"id":8229858},{"images":["http://pic4.zhimg.com/3908ef9ea3e27744d55135304e55bb9b.jpg"],"type":0,"id":8258897,"ga_prefix":"050512","title":"全球最丰厚的科学奖奖金，引力波发现团队拿到了"},{"title":"来一捧时鲜的蚕豆，在餐桌上用美味开启完美夏日","ga_prefix":"050511","images":["http://pic1.zhimg.com/78803459865d2cb8433a04a17efc8458.jpg"],"multipic":true,"type":0,"id":8254808},{"images":["http://pic4.zhimg.com/33bacf09b390c9b4b2fb75cea79fc9a7.jpg"],"type":0,"id":8256781,"ga_prefix":"050510","title":"男女生到了一定年龄，就应该开始做癌症筛查了"},{"images":["http://pic4.zhimg.com/fc07425517f47667c3bf1c94cba70587.jpg"],"type":0,"id":8233170,"ga_prefix":"050509","title":"这个吸睛又酷炫的技术，产业到底如何了？"},{"images":["http://pic3.zhimg.com/2d3f1dc2bb57bf28cddd2ed54574daae.jpg"],"type":0,"id":8257047,"ga_prefix":"050508","title":"老听说欧洲福利好，这可能是一场「非法集资」吗？"},{"images":["http://pic2.zhimg.com/789393c6613648dbb12d20d9e6b79105.jpg"],"type":0,"id":8256216,"ga_prefix":"050507","title":"90 后女大学生竞选国会议员，这是个真实事件"},{"images":["http://pic1.zhimg.com/4baa7f6ebe3a33559f7b579fec003a20.jpg"],"type":0,"id":8255831,"ga_prefix":"050507","title":"解密「从根儿上干掉你」的黑客攻击"},{"images":["http://pic3.zhimg.com/efd5f64f195e6565a9eac0d57e5166ee.jpg"],"type":0,"id":8254886,"ga_prefix":"050507","title":"可以爱我，可以恨我，反正头条都是我"},{"images":["http://pic1.zhimg.com/06315d758c280ca0ceda410acd2b0f70.jpg"],"type":0,"id":8257445,"ga_prefix":"050507","title":"读读日报 24 小时热门 TOP 5 · 五一我参加了北京一日游"},{"images":["http://pic4.zhimg.com/80e5c1986117a73d68de260d548c99bb.jpg"],"type":0,"id":8251572,"ga_prefix":"050506","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic4.zhimg.com/b55af67fa1460c866d2686e54d165a87.jpg","type":0,"id":8256781,"ga_prefix":"050510","title":"男女生到了一定年龄，就应该开始做癌症筛查了"},{"image":"http://pic1.zhimg.com/326397bed1fdd54761746956e69b4e5c.jpg","type":0,"id":8257445,"ga_prefix":"050507","title":"读读日报 24 小时热门 TOP 5 · 五一我参加了北京一日游"},{"image":"http://pic2.zhimg.com/ba79b9ebdcc05c62ef549910addc0fcd.jpg","type":0,"id":8256216,"ga_prefix":"050507","title":"90 后女大学生竞选国会议员，这是个真实事件"},{"image":"http://pic1.zhimg.com/50c69caea438248129aa10ba03214d24.jpg","type":0,"id":8233170,"ga_prefix":"050509","title":"这个吸睛又酷炫的技术，产业到底如何了？"},{"image":"http://pic3.zhimg.com/35e56275093c9afab2ae97820406cc66.jpg","type":0,"id":8254886,"ga_prefix":"050507","title":"可以爱我，可以恨我，反正头条都是我"}]
     */
    private String date;
    /**
     * title : 这种酷炫狂拽的运动装备，完全满足了我的中二之心
     * ga_prefix : 050515
     * images : ["http://pic2.zhimg.com/3736418541064d7b15f970540d4946c1.jpg"]
     * multipic : true
     * type : 0
     * id : 8254916
     */
    private List<News> stories;
    /**
     * image : http://pic4.zhimg.com/b55af67fa1460c866d2686e54d165a87.jpg
     * type : 0
     * id : 8256781
     * ga_prefix : 050510
     * title : 男女生到了一定年龄，就应该开始做癌症筛查了
     */

    private List<News> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<News> getStories() {
        return stories;
    }

    public void setStories(List<News> stories) {
        this.stories = stories;
    }

    public List<News> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<News> top_stories) {
        this.top_stories = top_stories;
    }
}
