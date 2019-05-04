package cn.myframe.utils;

import cn.myframe.entity.BusReceiverEntity;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class NameBuildUtils {

    private static String xings = "赵 钱 孙 李 周 吴 郑 王 冯 陈 褚 卫 " + "蒋 沈 韩 杨 朱 秦 尤 许 何 吕 施 张 " + "孔 曹 严 华 金 魏 陶 姜 戚 谢 邹 喻 "
            + "柏 水 窦 章 云 苏 潘 葛 奚 范 彭 郎 米 贝 明 臧 计 伏 成 戴 谈 宋 茅 庞 熊 纪 舒 屈 项 祝 董 梁 杜 阮 蓝 闵 井 段 富 巫 乌 焦 巴 弓 牧 隗 山 谷 车 侯 宓 蓬 全 郗 班 仰 秋 仲 伊 宫" +
            "宁 仇 栾 暴 甘 钭 历 戎 祖 武 符 刘 景 詹 束 龙 叶 幸 司 韶 郜 黎 蓟 溥 印 宿 白 怀 蒲 邰 从 鄂 索 咸 籍 赖 卓 蔺 屠 蒙 池 乔 阳 郁 胥 能 苍 双"+
            "闻 莘 党 翟 谭 贡 劳 逄 姬 申 扶 堵 向 古 易 慎 戈 廖 庾 终 暨 居 衡 步 欧 殳 沃 利 蔚 越 夔 隆 师 巩 厍 聂"+
            "万俟 司马 上官 欧阳 夏侯 诸葛 闻人 东方 赫连 皇甫 尉迟 公羊";
    private static String mings = "碧凡、夏菡、曼香、若烟、半梦、雅绿、冰蓝、灵槐、平安、书翠、翠风、香巧、代云、" + "友巧、听寒、梦柏、醉易、访旋、亦玉、凌萱、访卉、怀亦、笑蓝、春翠、靖柏、书雪、"
            + "乐枫、念薇、靖雁、寻春、恨山、从寒、忆香、觅波、静曼、凡旋、新波、代真、新蕾、" + "雁玉、冷卉、紫山、千琴、恨天、傲芙、盼山、怀蝶、冰兰、问旋、从南、白易、问筠、"
            + "如霜、半芹、寒雁、怜云、寻文、谷雪、乐萱、涵菡、海莲、傲蕾、青槐、冬儿、易梦、" + "惜雪、宛海、之柔、夏青"+"澄邈、德泽、海超、海阳、海荣、海逸、海昌、瀚钰、瀚文、" +
            "涵亮、涵煦、涵蓄、涵衍、浩皛、浩波、浩博、浩初、浩宕、浩歌、浩广、浩邈、浩气、浩思、浩言、鸿宝、" +
            "鸿波、鸿博、鸿才、鸿畅、鸿畴、鸿达、鸿德、鸿飞、鸿风、鸿福、鸿光、鸿晖、鸿朗、鸿文、鸿轩、鸿煊、鸿骞、" +
            "鸿远、鸿云、鸿哲、鸿祯、鸿志、鸿卓、嘉澍、光济、澎湃、彭泽、鹏池、鹏海、浦和、浦泽、瑞渊、越泽、博耘、" +
            "德运、辰宇、辰皓、辰钊、辰铭、辰锟、辰阳、辰韦、辰良、辰沛、晨轩、晨涛、晨濡、晨潍、鸿振、吉星、铭晨、起运、" +
            "运凡、运凯、运鹏、运浩、运诚、运良、运鸿、运锋、运盛、运升、运杰、运珧、运骏、运凯、运乾、维运、运晟、运莱、" +
            "运华、耘豪、星爵、星腾、星睿、星泽、星鹏、星然、震轩、震博、康震、震博、振强、振博、振华、振锐、振凯、振海、" +
            "振国、振平、昂然、昂雄、昂杰、昂熙、昌勋、昌盛、昌淼、昌茂、昌黎、昌燎、昌翰、晨朗、德明、德昌、德曜、范明、" +
            "飞昂、高旻、晗日、昊然、昊天、昊苍、昊英、昊宇、昊嘉、昊明、昊伟、昊硕、昊磊、昊东、鸿晖、鸿朗、华晖、金鹏、" +
            "晋鹏、敬曦、景明、景天、景浩、俊晖、君昊、昆琦、昆鹏、昆纬、昆宇、昆锐、昆卉、昆峰、昆颉、昆谊、昆皓、昆鹏、" +
            "昆明、昆杰、昆雄、昆纶、鹏涛、鹏煊、曦晨、曦之、新曦、旭彬、旭尧、旭鹏、旭东、旭炎、炫明、宣朗、学智、轩昂、" +
            "彦昌、曜坤、曜栋、曜文、曜曦、曜灿、曜瑞、智伟、智杰、智刚、智阳、昌勋、昌盛、昌茂、昌黎、昌燎、昌翰、晨朗、" +
            "昂然、昂雄、昂杰、昂熙、范明、飞昂、高朗、高旻、德明、德昌、德曜、智伟、智杰、智刚、智阳、瀚彭、旭炎、宣朗、" +
            "学智、昊然、昊天、昊苍、昊英、昊宇、昊嘉、昊明、昊伟、鸿朗、华晖、金鹏、晋鹏、敬曦、景明、景天、景浩、景行、" +
            "景中、景逸、景彰、昆鹏、昆明、昆杰、昆雄、昆纶、鹏涛、鹏煊、景平、俊晖、君昊、昆琦、昆鹏、昆纬、昆宇、昆锐、" +
            "昆卉、昆峰、昆颉、昆谊、轩昂、彦昌、曜坤、曜文、曜曦、曜灿、曜瑞、曦晨、曦之、新曦、鑫鹏、旭彬、旭尧、旭鹏、" +
            "旭东、浩轩、浩瀚、浩慨、浩阔、鸿熙、鸿羲、鸿禧、鸿信、泽洋、泽雨、哲瀚、胤运、佑运、允晨、运恒、运发、云天、" +
            "耘志、耘涛、振荣、振翱、中震、子辰、晗昱、瀚玥、瀚昂、瀚彭、景行、景中、景逸、景彰、绍晖、文景、曦哲、永昌、" +
            "子昂、智宇、智晖、晗日、晗昱、瀚昂、昊硕、昊磊、昊东、鸿晖、绍晖、文昂、文景、曦哲、永昌、子昂、智宇、智晖、" +
            "浩然、鸿运、辰龙、运珹、振宇、高朗、景平、鑫鹏、昌淼、炫明、昆皓、曜栋、文昂、恨桃、依秋、依波、香巧、紫萱、" +
            "涵易、忆之、幻巧、水风、安寒、白亦、惜玉、碧春、怜雪、听南、念蕾、紫夏、凌旋、芷梦、凌寒、梦竹、千凡、采波、" +
            "元冬、思菱、平卉、笑柳、雪卉、南蓉、谷梦、巧兰、绿蝶、飞荷、平安、芷荷、怀瑶、慕易、若芹、紫安、曼冬、寻巧、" +
            "寄波、尔槐、以旋、初夏、依丝、怜南、傲菡、谷蕊、笑槐、飞兰、笑卉、迎荷、元冬、痴安、妙绿、觅雪、寒安、沛凝、" +
            "白容、乐蓉、映安、依云、映冬、凡雁、梦秋、梦凡、秋巧、若云、元容、怀蕾、灵寒、天薇、翠安、乐琴、宛南、怀蕊、" +
            "白风、访波、亦凝、易绿、夜南、曼凡、亦巧、青易、冰真、白萱、友安、海之、小蕊、又琴、天风、若松、盼菡、秋荷、" +
            "香彤、语梦、惜蕊、迎彤、沛白、雁山、易蓉、雪晴、诗珊、春冬、又绿、冰绿、半梅、笑容、沛凝、映秋、盼烟、晓凡、" +
            "涵雁、问凝、冬萱、晓山、雁蓉、梦蕊、山菡、南莲、飞双、凝丝、思萱、怀梦、雨梅、冷霜、向松、迎丝、迎梅、雅彤、" +
            "香薇、以山、碧萱、寒云、向南、书雁、怀薇、思菱、忆文、翠巧、怀山、若山、向秋、凡白、绮烟、从蕾、天曼、又亦、" +
            "从安、绮彤、之玉、凡梅、依琴、沛槐、又槐、元绿、安珊、夏之、易槐、宛亦、白翠、丹云、问寒、易文、傲易、青旋、" +
            "思真、雨珍、幻丝、代梅、盼曼、妙之、半双、若翠、初兰、惜萍、初之、宛丝、寄南、小萍、静珊、千风、天蓉、雅青、" +
            "寄文、涵菱、香波、青亦、元菱、翠彤、春海、惜珊、向薇、冬灵、惜芹、凌青、谷芹、雁桃、映雁、书兰、盼香、向山、" +
            "寄风、访烟、绮晴、映之、醉波、幻莲、谷冬、傲柔、寄容、以珊、紫雪、芷容、书琴、寻桃、涵阳、怀寒、易云、代秋、" +
            "惜梦、尔烟、谷槐、怀莲、夜山、芷卉、向彤、新巧、语海、灵珊、凝丹、小蕾、迎夏、慕卉、飞珍、冰夏、亦竹、飞莲、" +
            "海白、元蝶、春蕾、怀绿、尔容、小玉、幼南、凡梦、碧菡、初晴、宛秋、傲旋、新之、凡儿、夏真、静枫、痴柏、恨蕊、" +
            "乐双、念薇、靖雁、寄松、丹蝶、元瑶、冰蝶、念波、迎松、海瑶、乐萱、凌兰、曼岚、若枫、傲薇、凡灵、乐蕊、秋灵、" +
            "谷槐、觅云、寻春、恨山、从寒、忆香、觅波、静曼、青寒、笑天、涵蕾、元柏、代萱、紫真、千青、雪珍、寄琴、绿蕊、" +
            "醉柳、诗翠、念瑶、孤风、曼彤、怀曼、香巧、采蓝、芷天、尔曼、巧蕊";
    private static String[] road=("重庆大厦,黑龙江路,十梅庵街,遵义路,湘潭街,瑞金广场,仙山街,仙山东路," +
            "仙山西大厦,白沙河路,赵红广场,机场路,民航街,长城南路,流亭立交桥,虹桥广场,长城大厦,礼阳路,风岗街," +
            "中川路,白塔广场,兴阳路,文阳街,绣城路,河城大厦,锦城广场,崇阳街,华城路,康城街,正阳路,和阳广场,中城路," +
            "江城大厦,顺城路,安城街,山城广场,春城街,国城路,泰城街,德阳路,明阳大厦,春阳路,艳阳街,秋阳路,硕阳街," +
            "青威高速,瑞阳街,丰海路,双元大厦,惜福镇街道,夏庄街道,古庙工业园,中山街,太平路,广西街,潍县广场," +
            "博山大厦,湖南路,济宁街,芝罘路,易州广场,荷泽四路,荷泽二街,荷泽一路,荷泽三大厦,观海二广场,广西支街," +
            "观海一路,济宁支街,莒县路,平度广场,明水路,蒙阴大厦,青岛路,湖北街,江宁广场,郯城街,天津路,保定街," +
            "安徽路,河北大厦,黄岛路,北京街,莘县路,济南街,宁阳广场,日照街,德县路,新泰大厦,荷泽路,山西广场," +
            "沂水路,肥城街,兰山路,四方街,平原广场,泗水大厦,浙江路,曲阜街,寿康路,河南广场,泰安路,大沽街,红山峡支路," +
            "西陵峡一大厦,台西纬一广场,台西纬四街,台西纬二路,西陵峡二街,西陵峡三路,台西纬三广场,台西纬五路," +
            "明月峡大厦,青铜峡路,台西二街,观音峡广场,瞿塘峡街,团岛二路,团岛一街,台西三路,台西一大厦,郓城南路," +
            "团岛三街,刘家峡路,西藏二街,西藏一广场,台西四街,三门峡路,城武支大厦,红山峡路,郓城北广场,龙羊峡路," +
            "西陵峡街,台西五路,团岛四街,石村广场,巫峡大厦,四川路,寿张街,嘉祥路,南村广场,范县路,西康街,云南路," +
            "巨野大厦,西江广场,鱼台街,单县路,定陶街,滕县路,钜野广场,观城路,汶上大厦,朝城路,滋阳街,邹县广场," +
            "濮县街,磁山路,汶水街,西藏路,城武大厦,团岛路,南阳街,广州路,东平街,枣庄广场,贵州街,费县路,南海大厦," +
            "登州路,文登广场,信号山支路,延安一街,信号山路,兴安支街,福山支广场,红岛支大厦,莱芜二路,吴县一街," +
            "金口三路,金口一广场,伏龙山路,鱼山支街,观象二路,吴县二大厦,莱芜一广场,金口二街,海阳路,龙口街,恒山路," +
            "鱼山广场,掖县路,福山大厦,红岛路,常州街,大学广场,龙华街,齐河路,莱阳街,黄县路,张店大厦,祚山路,苏州街," +
            "华山路,伏龙街,江苏广场,龙江街,王村路,琴屿大厦,齐东路,京山广场,龙山路,牟平街,延安三路,延吉街,南京广场," +
            "东海东大厦,银川西路,海口街,山东路,绍兴广场,芝泉路,东海中街,宁夏路,香港西大厦,隆德广场,扬州街,郧阳路," +
            "太平角一街,宁国二支路,太平角二广场,天台东一路,太平角三大厦,漳州路一路,漳州街二街,宁国一支广场," +
            "太平角六街,太平角四路,天台东二街,太平角五路,宁国三大厦,澳门三路,江西支街,澳门二路,宁国四街," +
            "大尧一广场,咸阳支街,洪泽湖路,吴兴二大厦,澄海三路,天台一广场,新湛二路,三明北街,新湛支路," +
            "湛山五街,泰州三广场,湛山四大厦,闽江三路,澳门四街,南海支路,吴兴三广场,三明南路,湛山二街," +
            "二轻新村镇,江南大厦,吴兴一广场,珠海二街,嘉峪关路,高邮湖街,湛山三路,澳门六广场,泰州二路," +
            "东海一大厦,天台二路,微山湖街,洞庭湖广场,珠海支街,福州南路,澄海二街,泰州四路,香港中大厦," +
            "澳门五路,新湛三街,澳门一路,正阳关街,宁武关广场,闽江四街,新湛一路,宁国一大厦,王家麦岛," +
            "澳门七广场,泰州一路,泰州六街,大尧二路,青大一街,闽江二广场,闽江一大厦,屏东支路,湛山一街," +
            "东海西路,徐家麦岛函谷关广场,大尧三路,晓望支街,秀湛二路,逍遥三大厦,澳门九广场,泰州五街," +
            "澄海一路,澳门八街,福州北路,珠海一广场,宁国二路,临淮关大厦,燕儿岛路,紫荆关街,武胜关广场," +
            "逍遥一街,秀湛四路,居庸关街,山海关路,鄱阳湖大厦,新湛路,漳州街,仙游路,花莲街,乐清广场," +
            "巢湖街,台南路,吴兴大厦,新田路,福清广场,澄海路,莆田街,海游路,镇江街,石岛广场,宜兴大厦," +
            "三明路,仰口街,沛县路,漳浦广场,大麦岛,台湾街,天台路,金湖大厦,高雄广场,海江街,岳阳路," +
            "善化街,荣成路,澳门广场,武昌路,闽江大厦,台北路,龙岩街,咸阳广场,宁德街,龙泉路,丽水街," +
            "海川路,彰化大厦,金田路,泰州街,太湖路,江西街,泰兴广场,青大街,金门路,南通大厦,旌德路," +
            "汇泉广场,宁国路,泉州街,如东路,奉化街,鹊山广场,莲岛大厦,华严路,嘉义街,古田路,南平广场")
            .split(",");


    private static String []province={"北京市","天津市","上海市","重庆市","河北省","山西省","辽宁省","吉林省","黑龙江省","江苏省",
            "浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","海南省",
            "四川省","贵州省","云南省","陕西省","甘肃省","青海省","台湾省","内蒙古自治区","广西壮族自治区","西藏自治区","宁夏回族自治区"
            ,"新疆维吾尔自治区","香港特别行政区","澳门特别行政区"};

    private static Random r = new Random();

    private static String[] xingArray = null;
    private static String[] mingArray = null;

    private static int xingLength = 0;
    private static int mingLength = 0;
    static{
        xingArray = xings.split(" ");
        mingArray = mings.split("、");
        xingLength = xingArray.length;
        mingLength = mingArray.length;
    }


    /**
     * 创建姓名
     * @return
     */
    public static String buildName() {
        String x = xingArray[r.nextInt(xingLength-1)];
        String m = mingArray[r.nextInt(mingLength-1)];
        return x+m;
    }

    /**
     * 创建地址
     * @return
     */
    public static String buildAddree() {
        String p = province[r.nextInt(province.length-1)];
        String ro = road[r.nextInt(road.length-1)];
        return p+ro+new Random().nextInt(1001)+"号";
    }

    /**
     * 汉字转为拼音
     * @param chinese
     * @return
     */
    public static String ToPinyin(String chinese){
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < newChar.length; i++) {
            if (newChar[i] > 128) {
                try {
                    pinyinStr =  pinyinStr+" "+ PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0];
                } catch (Exception e) {
                    System.out.println(chinese);
                    e.printStackTrace();
                }
            }else{
                pinyinStr =  pinyinStr+" "+newChar[i];
            }
        }
        return pinyinStr;
    }

    static AtomicLong atomicLong = new AtomicLong(60000000);
    public static BusReceiverEntity buildReceiver(){

        String name = NameBuildUtils.buildName();
        BusReceiverEntity entity = new BusReceiverEntity(atomicLong.incrementAndGet(),
                name,String.valueOf(new Random().nextInt(2000)), NameBuildUtils.buildAddree(),ToPinyin(name),new Random().nextInt(10));

        entity.setId(SnowflakeIdWorker.buildId());

        return entity;
    }






    public static void main(String[] args) {
        for(int i = 0 ;i<10000;i++){
            System.out.println(ToPinyin(NameBuildUtils.buildAddree()));
        }

    }


}
