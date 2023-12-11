package com.italycalibur.mall.tiny.jpa.core.modules.ums.dto;

import com.italycalibur.mall.tiny.jpa.entity.modules.ums.model.UmsMenu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 后台菜单节点封装
 * @author italycalibur
 * @since 2023/12/11
 */
@Getter
@Setter
public class UmsMenuNode extends UmsMenu {

    @Schema(description = "子级菜单")
    private List<UmsMenuNode> children;

}
