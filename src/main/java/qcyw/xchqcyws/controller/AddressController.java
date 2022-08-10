package qcyw.xchqcyws.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qcyw.xchqcyws.common.controller.BaseController;
import qcyw.xchqcyws.common.domain.AjaxResult;
import qcyw.xchqcyws.common.untils.StringUtils;
import qcyw.xchqcyws.entity.Address;
import qcyw.xchqcyws.entity.AddressUserView;
import qcyw.xchqcyws.service.AddressService;

import java.util.ArrayList;
import java.util.List;

/**
 * 棋茶一味地址薄 -控制层
 *
 * @author LUW
 * @date 2022/7/28
 * @Description
 */
@Api(tags = "AddressController")
@RestController
@RequestMapping("/AddressController")
public class AddressController extends BaseController {

    @Autowired
    private AddressService addressService;

    /**
     * 获取地址簿列表信息
     *
     * @return
     */
    @ApiOperation(value = "获取地址簿列表信息")
    @GetMapping("/list")
    public AjaxResult list(@RequestParam("openid") String openid) {
        try {
            List<AddressUserView> addressList = addressService.getAddressList(openid);
            return AjaxResult.success("OK", addressList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("获取地址簿列表信息错误");
    }

    /**
     * 新增地址簿
     */
    @ApiOperation(value = "新增地址簿")
    @PostMapping("/add")
    public AjaxResult add(@RequestParam("openid") String openid,
                          @RequestParam("consignee") String consignee,
                          @RequestParam("phone") String phone,
                          @RequestParam("address") String address,
                          @RequestParam("isDefault") String isDefault,
                          @RequestParam("province") String province,
                          @RequestParam("city") String city,
                          @RequestParam("area") String area ) {
        try {
            Address addresss = new Address();
            addresss.setDelFlag("1");
            addresss.setOpenid(openid);
            addresss.setConsignee(consignee);
            addresss.setPhone(phone);
            addresss.setAddress(address);
            addresss.setProvince(province);
            addresss.setCity(city);
            addresss.setArea(area);
            int isDefaults = 0;
            if (StringUtils.isNotEmpty(isDefault)) {
                isDefaults = Integer.parseInt(isDefault);
            }
            //判断这个用户有没有存过地址
            if (addressService.getAddressByIds(openid).size() != 0) {
                List<Address> addressByIds = addressService.getAddressByIds(openid);
                //有没有带入默认地址，如果带入则除了当前的为默认地址，其他全部改成非默认
                if (isDefaults == 1) {
                    addresss.setIsDefault(1);
                    for (int i = 0; i < addressByIds.size(); i++) {
                        addressByIds.get(i).setIsDefault(0);
                        addressService.updateAddress(addressByIds.get(i));
                    }
                }
                //如果没有带入默认地址，则直接存非默认
                else {
                    addresss.setIsDefault(0);
                }
            }
            //如果是第一次存，则为默认地址
            else {
                addresss.setIsDefault(1);
            }
            addressService.insertAddress(addresss);
            return AjaxResult.success("新增地址簿成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("新增地址簿错误");
    }

    /**
     * 修改地址簿
     */
    @ApiOperation(value = "修改地址簿")
    @PutMapping("/update")
    public AjaxResult update(@RequestParam("id") String id,
                             @RequestParam("openid") String openid,
                             @RequestParam("consignee") String consignee,
                             @RequestParam("phone") String phone,
                             @RequestParam("address") String address,
                             @RequestParam("isDefault") String isDefault,
                             @RequestParam("province") String province,
                             @RequestParam("city") String city,
                             @RequestParam("area") String area ) {
        try {
            Address addresss = new Address();
            addresss.setId(Integer.parseInt(id));
            addresss.setConsignee(consignee);
            addresss.setPhone(phone);
            addresss.setAddress(address);
            addresss.setProvince(province);
            addresss.setCity(city);
            addresss.setArea(area);
            addresss.setArea(openid);
            int isDefaults = 0;
            if (StringUtils.isNotEmpty(isDefault)) {
                isDefaults = Integer.parseInt(isDefault);
            }
            addresss.setIsDefault(isDefaults);
            addressService.updateAddress(addresss);
            return AjaxResult.success("修改地址簿成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("修改地址簿错误");
    }

    /**
     * 删除地址信息
     */
    @ApiOperation(value = "删除地址信息")
    @DeleteMapping("/delete")
    public AjaxResult delete(@RequestParam("openid") String openid,
                             @RequestParam("ids") String ids) {
        try {
            String[] Ids = ids.split("_");
            Address address = new Address();
            for (int i = 0; i < Ids.length; i++) {
                String id = Ids[i];
                addressService.deleteAddress(id,openid);
            }
            return AjaxResult.success("OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("删除地址信息错误");
    }
}
