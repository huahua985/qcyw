package qcyw.xchqcyws.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qcyw.xchqcyws.common.controller.BaseController;
import qcyw.xchqcyws.common.domain.AjaxResult;
import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.service.GoodsService;

import java.util.List;

/**
 * 棋茶一味商品 -控制层
 *
 * @date 2022/7/27
 * @Description
 */
@Api(tags = "GoodsController")
@RestController
@RequestMapping("/GoodsController")
public class GoodsController extends BaseController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 获取商品列表信息
     *
     * @return
     */
    @ApiOperation(value = "获取商品列表信息")
    @GetMapping("/list")
    public AjaxResult list(String goodsName) {
        try {
            List<Goods> goodsList = goodsService.getGoodsList(goodsName);
            return AjaxResult.success("OK",goodsList);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return AjaxResult.error("获取商品列表信息错误");
    }

    /**
     * 获取商品详情信息
     *
     * @param goodsId
     * @return
     */
    @ApiOperation(value = "获取商品详情信息")
    @GetMapping("/getGoodsId")
    public AjaxResult getGoodsId(String goodsId) {
        try {
            return AjaxResult.success("OK",goodsService.getGoodsId(goodsId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("获取商品详情信息错误");
    }
}
