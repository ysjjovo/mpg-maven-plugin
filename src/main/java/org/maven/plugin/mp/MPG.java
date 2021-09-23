package org.maven.plugin.mp;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import javax.inject.Inject;
//mvnDebug compile
//remote debug
@Mojo( name = "run")
public class MPG extends AbstractMojo {
    @Inject
    private MavenProject project;
//    @Inject
//    private RepositorySystem system;

    @Parameter(property = "output")
    private String output;
    @Parameter(property = "url")
    private  String url;
    @Parameter(property = "basePackage")
    private  String basePackage;
    @Parameter(property = "user")
    private  String user;
    @Parameter(property = "password")
    private  String password;
    @Parameter(property = "prefix")
    private  String prefix;
    @Parameter(property = "tables")
    private String[] tables;
    @Override
    public void execute() {
        System.out.println("url:" + url + ", package:" + basePackage + ",user:" + user + ", password:" + password + ",prefix:" + prefix + ",tables:" + tables );
        String moduleName = "";

        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        if(output == null){
            output = project.getBasedir().getAbsolutePath();
        }
        System.out.println("output:" + output);
        gc.setOutputDir(output + "/src/main/java");
        gc.setAuthor("autgen");
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setBaseColumnList(false);
        gc.setBaseResultMap(false);
        mpg.setGlobalConfig(gc);


        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(user);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent(basePackage);
        mpg.setPackageInfo(pc);

        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(tables);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(prefix);
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
