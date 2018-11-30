package io.geekidea.fastspringboot.test;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liujixiang
 * @date 2018/11/7
 */
public class CodeGenerator {

    private static final String USER_NAME = "fast_spring_boot";
    private static final String PASSWORD = "geekidea.io_LJX999";
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DRIVER_URL = "jdbc:mysql://203.104.32.94:3306/fast_spring_boot?useUnicode=true&characterEncoding=UTF-8&useSSL=false";

    private static final String PARENT_PACKAGE = "io.geekidea.fastspringboot";
    private static final String SUPER_ENTITY = PARENT_PACKAGE + ".common.entity.BaseEntity";
    private static final String[] SUPER_ENTITY_COMMON_COLUMNS = new String[]{};
    private static final String SUPER_CONTROLLER = PARENT_PACKAGE + ".common.web.controller.BaseController";
    private static final String SUPER_SERVICE = PARENT_PACKAGE + ".common.service.BaseService";
    private static final String SUPER_SERVICE_IMPL = PARENT_PACKAGE + ".common.service.impl.BaseServiceImpl";

    private static final String PROJECT_PACKAGE_PATH = "io/geekidea/fastspringboot";


    // ############################ 配置部分 start ############################
    // 模块名称
    private static final String MODULE_NAME = "system";
    // 作者
    private static final String AUTHOR = "liujixiang";
    // 生成的表名称
    private static final String TABLE_NAME = "sys_log";
    // 主键数据库列名称
    private static final String PK_ID_COLUMN_NAME = "log_id";
    // ############################ 配置部分 end ############################


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);                  // 是否打开输出目录
        gc.setSwagger2(true);               // 启用swagger注解
        gc.setIdType(IdType.ID_WORKER);     // 主键类型:ID_WORKER

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setServiceName("%sService");

        // 是否覆盖已有文件
        gc.setFileOverride(true);

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DRIVER_URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USER_NAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(MODULE_NAME);
        pc.setParent(PARENT_PACKAGE);
        pc.setController("web.controller");

        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("customField", "Hello " + this.getConfig().getGlobalConfig().getAuthor());
                // 查询参数包路径
                map.put("queryParamPath",PARENT_PACKAGE + StringPool.DOT + pc.getModuleName() + ".web.param." + underlineToPascal(TABLE_NAME) + "QueryParam");
                // 响应结果包路径
                map.put("queryVoPath",PARENT_PACKAGE + StringPool.DOT + pc.getModuleName() + ".web.vo." + underlineToPascal(TABLE_NAME) + "QueryVo");
                // 实体对象名称
                map.put("entityObjectName",underlineToCamel(TABLE_NAME));
                // service对象名称
                map.put("serviceObjectName",underlineToCamel(TABLE_NAME) + "Service");
                // mapper对象名称
                map.put("mapperObjectName",underlineToCamel(TABLE_NAME) + "Mapper");
                // 主键ID列名
                map.put("pkIdColumnName",PK_ID_COLUMN_NAME);
                // 主键ID驼峰名称
                map.put("pkIdCamelName",underlineToCamel(PK_ID_COLUMN_NAME));
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        // 自定义queryParam模板
        focList.add(new FileOutConfig("/templates/queryParam.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/"+ PROJECT_PACKAGE_PATH +"/" + pc.getModuleName() + "/web/param/" + tableInfo.getEntityName() + "QueryParam" + StringPool.DOT_JAVA;
            }
        });

        // 自定义queryVo模板
        focList.add(new FileOutConfig("/templates/queryVo.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/"+ PROJECT_PACKAGE_PATH +"/" + pc.getModuleName() + "/web/vo/" + tableInfo.getEntityName() + "QueryVo" + StringPool.DOT_JAVA;
            }
        });
        
        
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(SUPER_ENTITY);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass(SUPER_CONTROLLER);
        strategy.setSuperServiceClass(SUPER_SERVICE);
        strategy.setSuperServiceImplClass(SUPER_SERVICE_IMPL);
        strategy.setInclude(TABLE_NAME);
        strategy.setSuperEntityColumns(SUPER_ENTITY_COMMON_COLUMNS);
        strategy.setControllerMappingHyphenStyle(true);
        /**
         * 注意，根据实际情况，进行设置
         * 当表名称的前缀和模块名称一样时，会去掉表的前缀
         * 比如模块名称为user,表明为user_info,则生成的实体名称是Info.java,一定要注意
         */
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.execute();
    }

    public static String underlineToCamel(String underline){
        if (StringUtils.isNotBlank(underline)){
            return NamingStrategy.underlineToCamel(underline);
        }
        return null;
    }

    public static String underlineToPascal(String underline){
        if (StringUtils.isNotBlank(underline)){
            return NamingStrategy.capitalFirst(NamingStrategy.underlineToCamel(underline));
        }
        return null;
    }

}
