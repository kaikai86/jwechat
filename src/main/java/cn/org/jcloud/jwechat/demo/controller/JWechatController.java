package cn.org.jcloud.jwechat.demo.controller;

import cn.hutool.core.util.StrUtil;
import cn.org.jcloud.jwechat.WxMainService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title WxController
 * @Description 微信Controller
 * @Author ZhangKai
 * @Date 2020/4/1 0001
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@RestController
@RequestMapping("/wechat")
@CommonsLog
public class JWechatController {

    @Autowired
    private WxMainService wxMainService;


    @RequestMapping(method = RequestMethod.GET)
    public String bind(@RequestParam(name = "signature", required = false) String signature,
                       @RequestParam(name = "timestamp", required = false) String timestamp,
                       @RequestParam(name = "nonce", required = false) String nonce,
                       @RequestParam(name = "echostr", required = false) String echostr) {

        log.info("接收到来自微信服务器的认证消息：[{".concat(signature).concat(",").concat(timestamp).concat(",").concat(nonce).concat(",").concat(echostr).concat("}]"));

        if (StrUtil.isBlank(signature) || StrUtil.isBlank(timestamp) || StrUtil.isBlank(nonce) || StrUtil.isBlank(echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }

        if (wxMainService.check(timestamp, nonce, signature)) {
            log.info("bind weixin server success , and echostr is ".concat(echostr));
            return echostr;
        } else {
            // 绑定微信服务器失败
            log.warn("bind weixin server faile !!!");
        }
        return"非法请求";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handel(@RequestBody String requestBody, @RequestParam("signature") String signature,
                         @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce,
                         @RequestParam(name = "encrypt_type", required = false) String encType,
                         @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        log.info("接收到来自微信服务器的认证消息：[{".concat(signature).concat(",").concat(timestamp).concat(",").concat(nonce).concat("}]"));
        log.info("接收到来自微信服务器的用户消息：[{".concat(encType).concat(",").concat(msgSignature).concat(",[\n").concat(requestBody).concat("\n]}]"));
        if (!wxMainService.check(timestamp, nonce, signature)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }
        return "";

    }



}
