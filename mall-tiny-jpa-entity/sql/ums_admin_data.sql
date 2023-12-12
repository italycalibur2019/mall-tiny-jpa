-- ----------------------------
-- Records of ums_admin
-- ----------------------------
INSERT INTO public.ums_admin (id, create_by, create_time, update_by, update_time, email, icon, last_login_time, nick_name, "password", remark, status, username)
VALUES(1, -1, '2023-12-12 14:43:28.302', NULL, NULL, 'test@qq.com', '', NULL, '测试', 'e10adc3949ba59abbe56e057f20f883e', '测试账号', 1, 'test');
INSERT INTO public.ums_admin (id, create_by, create_time, update_by, update_time, email, icon, last_login_time, nick_name, "password", remark, status, username)
VALUES(3, -1, '2023-12-12 14:43:28.302', NULL, NULL, 'admin@qq.com', '', NULL, '超级管理员', 'e10adc3949ba59abbe56e057f20f883e', '系统管理员', 1, 'admin');
INSERT INTO public.ums_admin (id, create_by, create_time, update_by, update_time, email, icon, last_login_time, nick_name, "password", remark, status, username)
VALUES(4, -1, '2023-12-12 14:43:28.302', NULL, NULL, 'user@qq.com', '', NULL, '用户', 'e10adc3949ba59abbe56e057f20f883e', '普通用户', 1, 'user');
INSERT INTO public.ums_admin (id, create_by, create_time, update_by, update_time, email, icon, last_login_time, nick_name, "password", remark, status, username)
VALUES(6, -1, '2023-12-12 14:43:28.302', NULL, NULL, 'pAdmin@qq.com', '', NULL, '商品管理员', 'e10adc3949ba59abbe56e057f20f883e', '只有商品管理权限', 1, 'pAdmin');
INSERT INTO public.ums_admin (id, create_by, create_time, update_by, update_time, email, icon, last_login_time, nick_name, "password", remark, status, username)
VALUES(7, -1, '2023-12-12 14:43:28.303', NULL, NULL, 'oAdmin@qq.com', '', NULL, '订单管理员', 'e10adc3949ba59abbe56e057f20f883e', '只有订单管理权限', 1, 'oAdmin');
INSERT INTO public.ums_admin (id, create_by, create_time, update_by, update_time, email, icon, last_login_time, nick_name, "password", remark, status, username)
VALUES(10, -1, '2023-12-12 14:43:28.303', NULL, NULL, 'senpai@qq.com', '', NULL, '先辈', 'e10adc3949ba59abbe56e057f20f883e', '太臭了，不能用', 0, 'senpai');

-- ----------------------------
-- Records of ums_admin_login_log
-- ----------------------------
INSERT INTO public.ums_admin_login_log (id, create_by, create_time, update_by, update_time, address, admin_id, ip, user_agent)
VALUES(285, -1, '2023-12-12 14:46:24.844', NULL, NULL, NULL, 3, '0:0:0:0:0:0:0:1', NULL);
INSERT INTO public.ums_admin_login_log (id, create_by, create_time, update_by, update_time, address, admin_id, ip, user_agent)
VALUES(286, -1, '2023-12-12 14:46:24.846', NULL, NULL, NULL, 10, '0:0:0:0:0:0:0:1', NULL);

-- ----------------------------
-- Records of ums_admin_role_relation
-- ----------------------------
INSERT INTO public.ums_admin_role_relation (id, create_by, create_time, update_by, update_time, admin_id, role_id)
VALUES(26, -1, '2023-12-12 14:49:53.548', NULL, NULL, 3, 5);
INSERT INTO public.ums_admin_role_relation (id, create_by, create_time, update_by, update_time, admin_id, role_id)
VALUES(27, -1, '2023-12-12 14:49:53.548', NULL, NULL, 6, 1);
INSERT INTO public.ums_admin_role_relation (id, create_by, create_time, update_by, update_time, admin_id, role_id)
VALUES(28, -1, '2023-12-12 14:49:53.549', NULL, NULL, 7, 2);
INSERT INTO public.ums_admin_role_relation (id, create_by, create_time, update_by, update_time, admin_id, role_id)
VALUES(29, -1, '2023-12-12 14:49:53.550', NULL, NULL, 1, 5);
INSERT INTO public.ums_admin_role_relation (id, create_by, create_time, update_by, update_time, admin_id, role_id)
VALUES(30, -1, '2023-12-12 14:49:53.550', NULL, NULL, 4, 5);
INSERT INTO public.ums_admin_role_relation (id, create_by, create_time, update_by, update_time, admin_id, role_id)
VALUES(39, -1, '2023-12-12 14:49:53.553', NULL, NULL, 10, 8);

-- ----------------------------
-- Records of ums_menu
-- ----------------------------
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(1, -1, '2023-12-12 14:53:48.135', NULL, NULL, 1, 'product', 0, 'pms', 0, 0, '商品');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(2, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'product-list', 1, 'product', 1, 0, '商品列表');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(3, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'product-add', 1, 'addProduct', 1, 0, '添加商品');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(4, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'product-cate', 1, 'productCate', 1, 0, '商品分类');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(5, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'product-attr', 1, 'productAttr', 1, 0, '商品类型');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(6, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'product-brand', 1, 'brand', 1, 0, '品牌管理');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(7, -1, '2023-12-12 14:53:48.135', NULL, NULL, 1, 'order', 0, 'oms', 0, 0, '订单');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(8, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'product-list', 1, 'order', 7, 0, '订单列表');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(9, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'order-setting', 1, 'orderSetting', 7, 0, '订单设置');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(10, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'order-return', 1, 'returnApply', 7, 0, '退货申请处理');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(11, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'order-return-reason', 1, 'returnReason', 7, 0, '退货原因设置');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(12, -1, '2023-12-12 14:53:48.135', NULL, NULL, 1, 'sms', 0, 'sms', 0, 0, '营销');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(13, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'sms-flash', 1, 'flash', 12, 0, '秒杀活动列表');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(14, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'sms-coupon', 1, 'coupon', 12, 0, '优惠券列表');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(16, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'product-brand', 1, 'homeBrand', 12, 0, '品牌推荐');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(17, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'sms-new', 1, 'homeNew', 12, 0, '新品推荐');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(18, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'sms-hot', 1, 'homeHot', 12, 0, '人气推荐');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(19, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'sms-subject', 1, 'homeSubject', 12, 0, '专题推荐');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(20, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'sms-ad', 1, 'homeAdvertise', 12, 0, '广告列表');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(21, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'ums', 0, 'ums', 0, 0, '权限');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(22, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'ums-admin', 1, 'admin', 21, 0, '用户列表');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(23, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'ums-role', 1, 'role', 21, 0, '角色列表');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(24, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'ums-menu', 1, 'menu', 21, 0, '菜单列表');
INSERT INTO public.ums_menu (id, create_by, create_time, update_by, update_time, hidden, icon, "level", "name", parent_id, sort, title)
VALUES(25, -1, '2023-12-12 14:53:48.135', NULL, NULL, 0, 'ums-resource', 1, 'resource', 21, 0, '资源列表');

-- ----------------------------
-- Records of ums_resource
-- ----------------------------
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(1, -1, '2023-12-12 15:09:51.677', NULL, NULL, 1, '描述', '商品品牌管理', '/brand/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(2, -1, '2023-12-12 15:09:51.677', NULL, NULL, 1, '描述', '商品属性分类管理', '/productAttribute/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(3, -1, '2023-12-12 15:09:51.677', NULL, NULL, 1, '描述', '商品属性管理', '/productAttribute/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(4, -1, '2023-12-12 15:09:51.677', NULL, NULL, 1, '描述', '商品分类管理', '/productCategory/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(5, -1, '2023-12-12 15:09:51.677', NULL, NULL, 1, '描述', '商品管理', '/product/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(6, -1, '2023-12-12 15:09:51.677', NULL, NULL, 1, '描述', '商品库存管理', '/sku/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(8, -1, '2023-12-12 15:09:51.677', NULL, NULL, 2, '描述', '订单管理', '/order/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(9, -1, '2023-12-12 15:09:51.677', NULL, NULL, 2, '描述', '订单退货申请管理', '/returnApply/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(10, -1, '2023-12-12 15:09:51.677', NULL, NULL, 2, '描述', '退货原因管理', '/returnReason/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(11, -1, '2023-12-12 15:09:51.677', NULL, NULL, 2, '描述', '订单设置管理', '/orderSetting/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(12, -1, '2023-12-12 15:09:51.677', NULL, NULL, 2, '描述', '收货地址管理', '/companyAddress/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(13, -1, '2023-12-12 15:09:51.677', NULL, NULL, 3, '描述', '优惠券管理', '/coupon/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(14, -1, '2023-12-12 15:09:51.677', NULL, NULL, 3, '描述', '优惠券领取记录管理', '/couponHistory/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(15, -1, '2023-12-12 15:09:51.677', NULL, NULL, 3, '描述', '限时购活动管理', '/flash/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(16, -1, '2023-12-12 15:09:51.677', NULL, NULL, 3, '描述', '限时购商品关系管理', '/flashProductRelation/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(17, -1, '2023-12-12 15:09:51.677', NULL, NULL, 3, '描述', '限时购场次管理', '/flashSession/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(18, -1, '2023-12-12 15:09:51.677', NULL, NULL, 3, '描述', '首页轮播广告管理', '/home/advertise/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(19, -1, '2023-12-12 15:09:51.677', NULL, NULL, 3, '描述', '首页品牌管理', '/home/brand/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(20, -1, '2023-12-12 15:09:51.677', NULL, NULL, 3, '描述', '首页新品管理', '/home/newProduct/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(21, -1, '2023-12-12 15:09:51.677', NULL, NULL, 3, '描述', '首页人气推荐管理', '/home/recommendProduct/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(22, -1, '2023-12-12 15:09:51.677', NULL, NULL, 3, '描述', '首页专题推荐管理', '/home/recommendSubject/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(23, -1, '2023-12-12 15:09:51.677', NULL, NULL, 5, '描述', '商品优选管理', '/prefrenceArea/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(24, -1, '2023-12-12 15:09:51.677', NULL, NULL, 5, '描述', '商品专题管理', '/subject/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(25, -1, '2023-12-12 15:09:51.677', NULL, NULL, 4, '描述', '后台用户管理', '/admin/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(26, -1, '2023-12-12 15:09:51.677', NULL, NULL, 4, '描述', '后台用户角色管理', '/role/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(27, -1, '2023-12-12 15:09:51.677', NULL, NULL, 4, '描述', '后台菜单管理', '/menu/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(28, -1, '2023-12-12 15:09:51.677', NULL, NULL, 4, '描述', '后台资源分类管理', '/resourceCategory/**');
INSERT INTO public.ums_resource (id, create_by, create_time, update_by, update_time, category_id, description, "name", url)
VALUES(29, -1, '2023-12-12 15:09:51.677', NULL, NULL, 4, '描述', '后台资源管理', '/resource/**');

-- ----------------------------
-- Records of ums_resource_category
-- ----------------------------
INSERT INTO public.ums_resource_category (id, create_by, create_time, update_by, update_time, "name", sort)
VALUES(1, -1, '2023-12-12 15:18:35.184', NULL, NULL, '商品模块', 0);
INSERT INTO public.ums_resource_category (id, create_by, create_time, update_by, update_time, "name", sort)
VALUES(2, -1, '2023-12-12 15:18:35.184', NULL, NULL, '订单模块', 0);
INSERT INTO public.ums_resource_category (id, create_by, create_time, update_by, update_time, "name", sort)
VALUES(3, -1, '2023-12-12 15:18:35.184', NULL, NULL, '营销模块', 0);
INSERT INTO public.ums_resource_category (id, create_by, create_time, update_by, update_time, "name", sort)
VALUES(4, -1, '2023-12-12 15:18:35.184', NULL, NULL, '权限模块', 0);
INSERT INTO public.ums_resource_category (id, create_by, create_time, update_by, update_time, "name", sort)
VALUES(5, -1, '2023-12-12 15:18:35.184', NULL, NULL, '内容模块', 0);
INSERT INTO public.ums_resource_category (id, create_by, create_time, update_by, update_time, "name", sort)
VALUES(6, -1, '2023-12-12 15:18:35.184', NULL, NULL, '其他模块', 0);

-- ----------------------------
-- Records of ums_role
-- ----------------------------
INSERT INTO public.ums_role (id, create_by, create_time, update_by, update_time, admin_count, description, "name", sort, status)
VALUES(1, -1, '2023-12-12 15:20:25.847', NULL, NULL, 0, '只能查看及操作商品', '商品管理员', 0, 1);
INSERT INTO public.ums_role (id, create_by, create_time, update_by, update_time, admin_count, description, "name", sort, status)
VALUES(2, -1, '2023-12-12 15:20:25.847', NULL, NULL, 0, '只能查看及操作订单', '订单管理员', 0, 1);
INSERT INTO public.ums_role (id, create_by, create_time, update_by, update_time, admin_count, description, "name", sort, status)
VALUES(5, -1, '2023-12-12 15:20:25.847', NULL, NULL, 0, '拥有所有查看和操作功能', '超级管理员', 0, 1);
INSERT INTO public.ums_role (id, create_by, create_time, update_by, update_time, admin_count, description, "name", sort, status)
VALUES(8, -1, '2023-12-12 15:20:25.847', NULL, NULL, 0, '用于权限模块所有操作功能', '权限管理员', 0, 1);

-- ----------------------------
-- Records of ums_role_menu_relation
-- ----------------------------
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(33, -1, '2023-12-12 15:22:54.292', NULL, NULL, 1, 1);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(34, -1, '2023-12-12 15:22:54.292', NULL, NULL, 2, 1);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(35, -1, '2023-12-12 15:22:54.292', NULL, NULL, 3, 1);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(36, -1, '2023-12-12 15:22:54.292', NULL, NULL, 4, 1);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(37, -1, '2023-12-12 15:22:54.292', NULL, NULL, 5, 1);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(38, -1, '2023-12-12 15:22:54.292', NULL, NULL, 6, 1);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(53, -1, '2023-12-12 15:22:54.292', NULL, NULL, 7, 2);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(54, -1, '2023-12-12 15:22:54.292', NULL, NULL, 8, 2);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(55, -1, '2023-12-12 15:22:54.292', NULL, NULL, 9, 2);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(56, -1, '2023-12-12 15:22:54.292', NULL, NULL, 10, 2);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(57, -1, '2023-12-12 15:22:54.292', NULL, NULL, 11, 2);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(72, -1, '2023-12-12 15:22:54.292', NULL, NULL, 1, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(73, -1, '2023-12-12 15:22:54.292', NULL, NULL, 2, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(74, -1, '2023-12-12 15:22:54.292', NULL, NULL, 3, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(75, -1, '2023-12-12 15:22:54.292', NULL, NULL, 4, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(76, -1, '2023-12-12 15:22:54.292', NULL, NULL, 5, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(77, -1, '2023-12-12 15:22:54.292', NULL, NULL, 6, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(78, -1, '2023-12-12 15:22:54.292', NULL, NULL, 7, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(79, -1, '2023-12-12 15:22:54.292', NULL, NULL, 8, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(80, -1, '2023-12-12 15:22:54.292', NULL, NULL, 9, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(81, -1, '2023-12-12 15:22:54.292', NULL, NULL, 10, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(82, -1, '2023-12-12 15:22:54.292', NULL, NULL, 11, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(83, -1, '2023-12-12 15:22:54.292', NULL, NULL, 12, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(84, -1, '2023-12-12 15:22:54.292', NULL, NULL, 13, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(85, -1, '2023-12-12 15:22:54.292', NULL, NULL, 14, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(86, -1, '2023-12-12 15:22:54.292', NULL, NULL, 16, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(87, -1, '2023-12-12 15:22:54.292', NULL, NULL, 17, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(88, -1, '2023-12-12 15:22:54.292', NULL, NULL, 18, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(89, -1, '2023-12-12 15:22:54.292', NULL, NULL, 19, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(90, -1, '2023-12-12 15:22:54.292', NULL, NULL, 20, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(91, -1, '2023-12-12 15:22:54.292', NULL, NULL, 21, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(92, -1, '2023-12-12 15:22:54.292', NULL, NULL, 22, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(93, -1, '2023-12-12 15:22:54.292', NULL, NULL, 23, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(94, -1, '2023-12-12 15:22:54.292', NULL, NULL, 24, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(95, -1, '2023-12-12 15:22:54.292', NULL, NULL, 25, 5);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(106, -1, '2023-12-12 15:22:54.292', NULL, NULL, 21, 8);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(107, -1, '2023-12-12 15:22:54.292', NULL, NULL, 22, 8);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(108, -1, '2023-12-12 15:22:54.292', NULL, NULL, 23, 8);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(109, -1, '2023-12-12 15:22:54.292', NULL, NULL, 24, 8);
INSERT INTO public.ums_role_menu_relation (id, create_by, create_time, update_by, update_time, menu_id, role_id)
VALUES(110, -1, '2023-12-12 15:22:54.292', NULL, NULL, 25, 8);

-- ----------------------------
-- Records of ums_role_resource_relation
-- ----------------------------
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(103, -1, '2023-12-12 15:31:09.908', NULL, NULL, 8, 2);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(104, -1, '2023-12-12 15:31:09.908', NULL, NULL, 9, 2);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(105, -1, '2023-12-12 15:31:09.908', NULL, NULL, 10, 2);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(106, -1, '2023-12-12 15:31:09.908', NULL, NULL, 11, 2);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(107, -1, '2023-12-12 15:31:09.908', NULL, NULL, 12, 2);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(142, -1, '2023-12-12 15:31:09.908', NULL, NULL, 1, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(143, -1, '2023-12-12 15:31:09.908', NULL, NULL, 2, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(144, -1, '2023-12-12 15:31:09.908', NULL, NULL, 3, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(145, -1, '2023-12-12 15:31:09.908', NULL, NULL, 4, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(146, -1, '2023-12-12 15:31:09.908', NULL, NULL, 5, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(147, -1, '2023-12-12 15:31:09.908', NULL, NULL, 6, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(148, -1, '2023-12-12 15:31:09.908', NULL, NULL, 8, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(149, -1, '2023-12-12 15:31:09.908', NULL, NULL, 9, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(150, -1, '2023-12-12 15:31:09.908', NULL, NULL, 10, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(151, -1, '2023-12-12 15:31:09.908', NULL, NULL, 11, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(152, -1, '2023-12-12 15:31:09.908', NULL, NULL, 12, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(153, -1, '2023-12-12 15:31:09.908', NULL, NULL, 13, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(154, -1, '2023-12-12 15:31:09.908', NULL, NULL, 14, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(155, -1, '2023-12-12 15:31:09.908', NULL, NULL, 15, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(156, -1, '2023-12-12 15:31:09.908', NULL, NULL, 16, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(157, -1, '2023-12-12 15:31:09.908', NULL, NULL, 17, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(158, -1, '2023-12-12 15:31:09.908', NULL, NULL, 18, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(159, -1, '2023-12-12 15:31:09.908', NULL, NULL, 19, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(160, -1, '2023-12-12 15:31:09.908', NULL, NULL, 20, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(161, -1, '2023-12-12 15:31:09.908', NULL, NULL, 21, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(162, -1, '2023-12-12 15:31:09.908', NULL, NULL, 22, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(163, -1, '2023-12-12 15:31:09.908', NULL, NULL, 23, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(164, -1, '2023-12-12 15:31:09.908', NULL, NULL, 24, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(165, -1, '2023-12-12 15:31:09.908', NULL, NULL, 25, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(166, -1, '2023-12-12 15:31:09.908', NULL, NULL, 26, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(167, -1, '2023-12-12 15:31:09.908', NULL, NULL, 27, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(168, -1, '2023-12-12 15:31:09.908', NULL, NULL, 28, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(169, -1, '2023-12-12 15:31:09.908', NULL, NULL, 29, 5);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(170, -1, '2023-12-12 15:31:09.908', NULL, NULL, 1, 1);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(171, -1, '2023-12-12 15:31:09.908', NULL, NULL, 2, 1);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(172, -1, '2023-12-12 15:31:09.908', NULL, NULL, 3, 1);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(173, -1, '2023-12-12 15:31:09.908', NULL, NULL, 4, 1);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(174, -1, '2023-12-12 15:31:09.908', NULL, NULL, 5, 1);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(175, -1, '2023-12-12 15:31:09.908', NULL, NULL, 6, 1);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(176, -1, '2023-12-12 15:31:09.908', NULL, NULL, 23, 1);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(177, -1, '2023-12-12 15:31:09.908', NULL, NULL, 24, 1);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(211, -1, '2023-12-12 15:31:09.908', NULL, NULL, 25, 8);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(212, -1, '2023-12-12 15:31:09.908', NULL, NULL, 26, 8);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(213, -1, '2023-12-12 15:31:09.908', NULL, NULL, 27, 8);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(214, -1, '2023-12-12 15:31:09.908', NULL, NULL, 28, 8);
INSERT INTO public.ums_role_resource_relation (id, create_by, create_time, update_by, update_time, resource_id, role_id)
VALUES(215, -1, '2023-12-12 15:31:09.908', NULL, NULL, 29, 8);
