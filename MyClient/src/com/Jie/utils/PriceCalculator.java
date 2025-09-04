package com.Jie.utils;

/**
 * 价格计算工具类
 */
public class PriceCalculator {
    
    /**
     * 计算商品总价
     * @param goodsInfos 商品信息数组，格式：商品ID,商品名称,单价,库存
     * @param quantities 对应的购买数量
     * @return 总价
     */
    public static double calculateTotal(String[] goodsInfos, String[] quantities) {
        double total = 0.0;
        
        if (goodsInfos == null || quantities == null) {
            return total;
        }
        
        int length = Math.min(goodsInfos.length, quantities.length);
        
        for (int i = 0; i < length; i++) {
            if (goodsInfos[i] != null && !goodsInfos[i].trim().isEmpty() 
                && quantities[i] != null && !quantities[i].trim().isEmpty()) {
                
                try {
                    // 解析商品信息，格式：商品ID,商品名称,单价,库存
                    String[] goodsInfo = goodsInfos[i].split(",");
                    if (goodsInfo.length >= 4 && !goodsInfo[2].equals("null")) {
                        double price = Double.parseDouble(goodsInfo[2]);
                        int stock = Integer.parseInt(goodsInfo[3]);
                        int quantity = Integer.parseInt(quantities[i]);
                        
                        if (quantity > 0) { // 确保数量大于0
                            if (quantity <= stock) { // 检查库存充足
                                total += price * quantity;
                            } else {
                                // 库存不足，抛出异常
                                throw new IllegalArgumentException("商品 " + goodsInfo[1] + " 库存不足！当前库存：" + stock + "，请求数量：" + quantity);
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    // 解析失败，跳过该商品
                    System.err.println("价格计算失败：" + goodsInfos[i] + " 数量：" + quantities[i]);
                }
            }
        }
        
        return total;
    }
    
    /**
     * 验证库存是否充足
     * @param goodsInfos 商品信息数组，格式：商品ID,商品名称,单价,库存
     * @param quantities 对应的购买数量
     * @return 库存验证结果消息，null表示验证通过
     */
    public static String validateStock(String[] goodsInfos, String[] quantities) {
        if (goodsInfos == null || quantities == null) {
            return "商品信息或数量不能为空";
        }
        
        int length = Math.min(goodsInfos.length, quantities.length);
        
        for (int i = 0; i < length; i++) {
            if (goodsInfos[i] != null && !goodsInfos[i].trim().isEmpty() 
                && quantities[i] != null && !quantities[i].trim().isEmpty()) {
                
                try {
                    // 解析商品信息，格式：商品ID,商品名称,单价,库存
                    String[] goodsInfo = goodsInfos[i].split(",");
                    if (goodsInfo.length >= 4 && !goodsInfo[2].equals("null")) {
                        int stock = Integer.parseInt(goodsInfo[3]);
                        int quantity = Integer.parseInt(quantities[i]);
                        
                        if (quantity > 0) { // 确保数量大于0
                            if (quantity > stock) { // 检查库存不足
                                return "商品 \"" + goodsInfo[1] + "\" 库存不足！\n当前库存：" + stock + "，请求数量：" + quantity;
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    return "商品数量格式错误：" + quantities[i];
                }
            }
        }
        
        return null; // 验证通过
    }
    
    /**
     * 格式化价格显示
     * @param price 价格
     * @return 格式化后的价格字符串
     */
    public static String formatPrice(double price) {
        return String.format("%.2f元", price);
    }
}
