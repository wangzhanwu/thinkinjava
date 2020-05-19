package com.wzw.main;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JDK8.0中的流
 * @author WZW
 */
public class LStream {
    public static void main(String[] args) {
        method4();
    }

    /**
     * string数组类型
     */
    public static void method1() {
        List<String> list = Arrays.asList("qw", "da", "", "fasda", " ");
        List<String> filterd = list.stream().filter(s -> !s.trim().isEmpty()).collect(Collectors.toList());
        filterd.forEach(System.out::println);

        String str = list.stream().filter(s -> !s.trim().isEmpty()).collect(Collectors.joining("|"));
        System.out.println(str);
    }

    /**
     * 去重
     */
    public static void method2() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,6,6,2,3);
        List<Integer> squareList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squareList.forEach(System.out::println);

        Stream.of("apple","banana","orange","waltermaleon","grape").map(e -> e.length()).forEach(System.out :: println);
    }

    /**
     * 统计整形数组的内容
     */
    public static void method3() {
        List<Integer> numbers = Arrays.asList(12,4,2,5,123,54,343,123,544,999);
        IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());

    }

    public static void method4() {
        String[] stations = {"52323","52418","52424","52436","52446","52447","52515","52533","52546","52557","52643","52652","52656","52661","52674","52679","52681","52784","52787","52797","52881","52884","52885","52889","52895","52896","52978","52980","52981","52982","52983","52984","52985","52986","52988","52993","52995","52996","52998","53821","53829","53906","53908","53915","53917","53923","53924","53925","53926","53927","53928","53930","53934","53935","53937","56071","56074","56080","56081","56082","56084","56091","56092","56093","56094","56095","56096","56192","57001","57002","57004","57006","57007","57008","57011","57012","57014","57102","57105","57110","57111","W1002","W1003","W1006","W1010","W1012","W1013","W1014","W1016","W1017","W1018","W1019","W1020","W1023","W1024","W1025","W1027","W1028","W1029","W1030","W1033","W1035","W1036","W1037","W1038","W1039","W1041","W1042","W1043","W1044","W1045","W1049","W1051","W1053","W1054","W1056","W1057","W1058","W1059","W1061","W1062","W1071","W1074","W1077","W1078","W1079","W1080","W1082","W1083","W1084","W1085","W1087","W1088","W1089","W1092","W1100","W1101","W1102","W1104","W1106","W1107","W1120","W1602","W1603","W1604","W1605","W1606","W1608","W1609","W1610","W1611","W1612","W1613","W2004","W2005","W2006","W2007","W2008","W2009","W2010","W2011","W2012","W2013","W2015","W2016","W2017","W2018","W2020","W2021","W2022","W2023","W2024","W2025","W2026","W2028","W2029","W2031","W2032","W2033","W2034","W2035","W2036","W2037","W2039","W2040","W2041","W2043","W2044","W2046","W2047","W2048","W2049","W2050","W2051","W2052","W2053","W2054","W2055","W2056","W2057","W2058","W2059","W2062","W2063","W2064","W2065","W2066","W2067","W2071","W2073","W2074","W2075","W2076","W2077","W2078","W2085","W2086","W2087","W2088","W2089","W2090","W2091","W2092","W2094","W2096","W2097","W2098","W2099","W2100","W2101","W2102","W2105","W2106","W2108","W2109","W2110","W2111","W2113","W2114","W2115","W2116","W2118","W2119","W2120","W2501","W2502","W2503","W2504","W2505","W2506","W2508","W2510","W2511","W2512","W2513","W2514","W2515","W2516","W2517","W2518","W2519","W2520","W2521","W2522","W2524","W2525","W2530","W2531","W2532","W2533","W2534","W2535","W2537","W2538","W2539","W2541","W2542","W2546","W2547","W2548","W2549","W2550","W2552","W2553","W2554","W2556","W2557","W2559","W2560","W2561","W2562","W2563","W2564","W2565","W2566","W2567","W2568","W2569","W2571","W2572","W2573","W2575","W2576","W2577","W2578","W2579","W2580","W2581","W2582","W2583","W2584","W2585","W2586","W2587","W2602","W2603","W2604","W2610","W2611","W2612","W2613","W3001","W3002","W3003","W3004","W3005","W3006","W3007","W3008","W3010","W3012","W3013","W3014","W3015","W3016","W3017","W3018","W3019","W3022","W3024","W3025","W3026","W3027","W3028","W3029","W3030","W3031","W3032","W3033","W3034","W3036","W3037","W3038","W3039","W3040","W3041","W3101","W3102","W3103","W3104","W3105","W3107","W3108","W3201","W3202","W3204","W3205","W3206","W3207","W3208","W3209","W3210","W3211","W3212","W3213","W3214","W3216","W3217","W3219","W3221","W3222","W3223","W3225","W3227","W3301","W3303","W3304","W3305","W3340","W3341","W3342","W3343","W3344","W3345","W3346","W3347","W3348","W3349","W3368","W3369","W3381","W3383","W3384","W3420","W3421","W3422","W3423","W3424","W3425","W3426","W3427","W3460","W3461","W3462","W3463","W3464","W3466","W3468","W3501","W3502","W3504","W3505","W3506","W3507","W3508","W3509","W3511","W3512","W3514","W3515","W3516","W3517","W3519","W3520","W3521","W3523","W3601","W3602","W3603","W3604","W3605","W3606","W3701","W3702","W3703","W3704","W3705","W3707","W3709","W3801","W3802","W3803","W3804","W3805","W3806","W3809","W3811","W3812","W3813","W3814","W3901","W3902","W3903","W3905","W3907","W3909","W3910","W3911","W3912","W3913","W3914","W3915","W3916","W3917","W3919","W3920","W3921","W3922","W4002","W4003","W4005","W4008","W4014","W4016","W4017","W4018","W4019","W4020","W4030","W4033","W4034","W4036","W4037","W4041","W4042","W4043","W4047","W4048","W4050","W4051","W4052","W4054","W4055","W4056","W4058","W4060","W4061","W4064","W4065","W4066","W4070","W4071","W4073","W4075","W4076","W4077","W4078","W4079","W4081","W4083","W4085","W4086","W4088","W4089","W4094","W4095","W4096","W4099","W4100","W4101","W4103","W4104","W4106","W4108","W4109","W4110","W4112","W4113","W4114","W4116","W4117","W4118","W4120","W4123","W4124","W4130","W4132","W4133","W4135","W4137","W4138","W4140","W4141","W4142","W4144","W4145","W4148","W4149","W4160","W4161","W4163","W4164","W4165","W4166","W4167","W4168","W4170","W4171","W4172","W4173","W4174","W4175","W4176","W4178","W4179","W4190","W4191","W4193","W4194","W4195","W4197","W4198","W4199","W4200","W4201","W4202","W4203","W4204","W4205","W4206","W4207","W4214","W4215","W4216","W4217","W4218","W4219","W4220","W4221","W4222","W4225","W4226","W4227","W4228","W4229","W4230","W4231","W4232","W4233","W4234","W4235","W4236","W4238","W4239","W4240","W4241","W4242","W4243","W4244","W4245","W4246","W4247","W4248","W4249","W4250","W4251","W4252","W4253","W4254","W4255","W4256","W4257","W4258","W4259","W4260","W4262","W4263","W4264","W4265","W4266","W4267","W4268","W4269","W4270","W4271","W4272","W4273","W4274","W4275","W4276","W4278","W4279","W5001","W5003","W5004","W5005","W5006","W5007","W5008","W5010","W5012","W5013","W5014","W5016","W5031","W5032","W5033","W5035","W5036","W5037","W5038","W5039","W5040","W5041","W5042","W5044","W5045","W5046","W5047","W5049","W5050","W5051","W5052","W5053","W5054","W5055","W5056","W5057","W5058","W5060","W5062","W5063","W5101","W5102","W5103","W5104","W5108","W5110","W5115","W5116","W5118","W5121","W5141","W5142","W5143","W5144","W5145","W5146","W5147","W5149","W5150","W5151","W5152","W5153","W5154","W5155","W5156","W5157","W5158","W5159","W5160","W5161","W5162","W5163","W5164","W5165","W5166","W5167","W5168","W5169","W5170","W5171","W5172","W5201","W5202","W5203","W5204","W5205","W5207","W5209","W5210","W5213","W5214","W5216","W5221","W5222","W5223","W5224","W5225","W5226","W5228","W5229","W5230","W5231","W5232","W5233","W5234","W5235","W5236","W5237","W5238","W5303","W5305","W5306","W5307","W5308","W5309","W5314","W5402","W5403","W5404","W5406","W5407","W5409","W5410","W5412","W5413","W5414","W5415","W5502","W5504","W5508","W5509","W5510","W5511","W5516","W5517","W5518","W5519","W5601","W5602","W5604","W5606","W5607","W5609","W5614","W5616","W6001","W6002","W6003","W6005","W6006","W6007","W6008","W6009","W6010","W6011","W6013","W6015","W6016","W6018","W6019","W6020","W6021","W6022","W6023","W6025","W6027","W6028","W6030","W6031","W6032","W6033","W6034","W6035","W6036","W6037","W6038","W6039","W6041","W6043","W6044","W6045","W6046","W6047","W6048","W6049","W6051","W6052","W6054","W6055","W6057","W6058","W6059","W6061","W6063","W6064","W6066","W6067","W6068","W6072","W6073","W6074","W6076","W6078","W6079","W6081","W6082","W6083","W6085","W6086","W6087","W6088","W6089","W6092","W6093","W6094","W6095","W6096","W6097","W6098","W6099","W6100","W6101","W6102","W6103","W6104","W6105","W6106","W6107","W6108","W6109","W6110","W6111","W6112","W6113","W6114","W6115","W6117","W6118","W6119","W6120","W6122","W6123","W6124","W6125","W6126","W6128","W6130","W6132","W6133","W6134","W6135","W6136","W6137","W6138","W6139","W6141","W6142","W6143","W6144","W6145","W6147","W6148","W6149","W6152","W6153","W6154","W6155","W6156","W6157","W6158","W6159","W6160","W6161","W6162","W6163","W6164","W6165","W6167","W6169","W6170","W6171","W6172","W6174","W6178","W6180","W6182","W6183","W6184","W6185","W6186","W6188","W6190","W6196","W6197","W6198","W6199","W6200","W6201","W6202","W6203","W6204","W6205","W6207","W6208","W6209","W6210","W6211","W6213","W6214","W6215","W6216","W6217","W6219","W6220","W6221","W6223","W6224","W6225","W6226","W6227","W6228","W6229","W6230","W6231","W6232","W6233","W6234","W6235","W6236","W6237","W6240","W6241","W6242","W6243","W6244","W6245","W6246","W6247","W6248","W6249","W6250","W6251","W6252","W6253","W6254","W6255","W6256","W6257","W6258","W6259","W6260","W6261","W6263","W6264","W6265","W6266","W6267","W6268","W6269","W6270","W6272","W6273","W6274","W6275","W6276","W6277","W6278","W6279","W6280","W6281","W6282","W6283","W6284","W6285","W6286","W6287","W6288","W6289","W6290","W6291","W6292","W6293","W6294","W6295","W6296","W6297","W6298","W6299","W6300","W6302","W6303","W6304","W6306","W6307","W6309","W6310","W6311","W6312","W6313","W6314","W6315","W6316","W6317","W6318","W6319","W6320","W6321","W6322","W6323","W6324","W6325","W6326","W6327","W6328","W6329","W6330","W6331","W6332","W6333","W6334","W6335","W6336","W6337","W6338","W6340","W6341","W6342","W6343","W6344","W6345","W6346","W6347","W6348","W6349","W6350","W6351","W6353","W6355","W6356","W6357","W6358","W6359","W6360","W6361","W6362","W6363","W6364","W6365","W6366","W6367","W6368","W6369","W6370","W6371","W6372","W7001","W7002","W7003","W7004","W7005","W7007","W7008","W7009","W7010","W7011","W7012","W7013","W7014","W7015","W7016","W7101","W7102","W7104","W7106","W7107","W7109","W7110","W7201","W7203","W7205","W7207","W7208","W7209","W7210","W7302","W7303","W7304","W7305","W7308","W7309","W7310","W7311","W7312","W7313","W7314","W7315","W7317","W7318","W7319","W7320","W7321","W7322","W7323","W7324","W7325","W7326","W7327","W7328","W7329","W7330","W7401","W7402","W7403","W7404","W7405","W7406","W7407","W7408","W7410","W7412","W7413","W7414","W7502","W7503","W7504","W7505","W7506","W7507","W7509","W7510","W7512","W7513","W7514","W7515","W7516","W7517","W7518","W7519","W7520","W7521","W7522","W7523","W7524","W7525","W7526","W7527","W7528","W7529","W7530","W7531","W7532","W7534","W7601","W7602","W7603","W7604","W7605","W7607","W7608","W7609","W7610","W7611","W7612","W7613","W7614","W7615","W7616","W7617","W7618","W7619","W7620","W7621","W8002","W8004","W8007","W8010","W8011","W8012","W8022","W8025","W8029","W8030","W8035","W8036","W8037","W8038","W8040","W8041","W8042","W8043","W8044","W8045","W8046","W8047","W8049","W8050","W8051","W8052","W8053","W8054","W8055","W8056","W8057","W8058","W8060","W8061","W8062","W8063","W8064","W8065","W8066","W8067","W8068","W8070","W8071","W8073","W8077","W8086","W8088","W8090","W8092","W8093","W8094","W8095","W8096","W8098","W8099","W8100","W8101","W8102","W8103","W8123","W8124","W8125","W8127","W8129","W8130","W8131","W8132","W8133","W8134","W8135","W8136","W8137","W8138","W8139","W8140","W8141","W8142","W8143","W8144","W8145","W8146","W8147","W8148","W8149","W8150","W8151","W8152","W8153","W8154","W9001","W9004","W9005","W9006","W9007","W9009","W9010","W9011","W9012","W9013","W9014","W9015","W9017","W9018","W9021","W9023","W9024","W9027","W9028","W9029","W9031","W9032","W9033","W9034","W9035","W9036","W9037","W9038","W9039","W9040","W9041","W9042","W9043","W9044","W9045","W9047","W9048","W9049","W9051","W9052","W9087","W9092","W9093","W9095","W9096","W9097","W9099","W9103","W9109","W9114","W9115","W9119","W9122","W9123","W9125","W9126","W9127","W9147","W9148","W9156","W9157","W9158","W9159","W9200","W9201","W9202","W9203","W9204","W9205","W9206","W9207","W9208","W9209","W9210","W9211","W9212","W9213","W9214","W9215","W9216","W9217","W9218","W9219","W9220","W9221","W9222","W9223","W9224","W9225","W9226","W9228","W9229","W9230","W9231","W9249","W9250","W9251","W9252","W9253","W9254","W9255","W9256","W9257","W9258","W9259","W9260","W9261","W9262","W9263","W9264","W9265","W9266","W9267","W9268","W9269","W9270","W9271","W9272","W9273","W9274","W9501","W9502","W9507","W9508","W9509","W9511","W9513","W9515","W9516","W9517","W9520","W9521","W9522","W9523","W9525","W9527","W9528","W9529","W9533","W9535","W9536","W9537","W9538","W9539","W9541","W9542","W9544","W9545","W9546","W9548","W9552","W9554","W9555","W9556","W9557","W9559","W9560","W9561","W9563","W9564","W9565","W9567","W9569","W9571","W9572","W9573","W9574","W9575","W9576","W9578","W9579","W9580","W9582","W9583","W9584","W9585","W9586","W9587","W9588","W9589","W9590","W9591","W9592","W9594","W9595","W9596","W9597","W9598","W9599","W9601","W9602","W9603","W9604","W9605","W9606","W9607","W9609","W9610","W9611","W9612","W9613","W9614","W9615","W9619","W9620","W9621","W9622","W9623","W9624","W9625","W9628","W9629","W9630","W9631","W9632","W9633","W9635","W9636","W9637","W9638","W9639","W9640","W9644","W9645","W9646","W9647","W9648","W9649","W9650","W9651","W9652","W9653","W9654","W9655","W9656","W9657","W9658","W9659","W9660","W9661","W9662","W9663","W9664","W9665","W9667","W9668","W9669"};
        long count = Arrays.asList(stations).stream().count();
        System.out.println(count);
    }
}
