package qcyw.xchqcyws.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qcyw.xchqcyws.common.controller.BaseController;
import qcyw.xchqcyws.common.domain.AjaxResult;
import qcyw.xchqcyws.common.untils.UUIDGenerator;
import qcyw.xchqcyws.entity.Address;
import qcyw.xchqcyws.service.AddressService;

import java.util.List;

/**
 * 棋茶一味地址薄 -控制层
 *
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
    public AjaxResult list(Address address) {
        try {
            List<Address> addressList = addressService.getAddressList(address);
            return AjaxResult.success("OK",addressList);
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
    public AjaxResult add(@RequestBody Address address) {
        try {
            address.setId(UUIDGenerator.getUUID());
            address.setDelFlag("1");
            //myCart.setUserId();
            //myCart.setCreateBy();
            addressService.insertAddress(address);
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
    public AjaxResult update(@RequestBody Address address) {
        try {
            addressService.updateAddress(address);
            return AjaxResult.success("修改地址簿成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("修改地址簿错误");
    }
}
