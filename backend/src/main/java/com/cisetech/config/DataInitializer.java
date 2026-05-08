package com.cisetech.config;

import com.cisetech.entity.*;
import com.cisetech.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ConfigRepository configRepository;
    private final BusinessServiceRepository businessServiceRepository;
    private final ProductRepository productRepository;
    private final SolutionRepository solutionRepository;
    private final QualificationRepository qualificationRepository;
    private final AwardRepository awardRepository;
    private final CompanyInfoRepository companyInfoRepository;
    private final ServiceNetworkRepository serviceNetworkRepository;

    @Override
    public void run(String... args) {
        initCompanyInfo();
        initConfigs();
        initBusinessServices();
        initProducts();
        initSolutions();
        initQualifications();
        initAwards();
        initServiceNetworks();
    }

    private void initCompanyInfo() {
        if (companyInfoRepository.count() == 0) {
            CompanyInfo companyInfo = new CompanyInfo();
            companyInfo.setCompanyName("上海申朴信息技术股份有限公司");
            companyInfo.setShortName("申朴信息");
            companyInfo.setStockCode("870221");
            companyInfo.setLogoUrl("/logo.png");
            companyInfo.setSlogan("融智于用");
            companyInfo.setCoreConcept("融智于用");
            companyInfo.setBrandConcept("申信达成，朴心进取");
            companyInfo.setServicePhilosophy("用心创造价值，真诚赢得信赖");
            companyInfo.setFoundedYear(2010);
            companyInfo.setDescription("上海申朴信息技术股份有限公司成立于2010年，是国内领先的金融科技与企业数字化转型解决方案服务商。公司专注于为银行、保险、证券、互联网等行业客户提供全栈式数字化转型服务，拥有完整的AI、大数据、信创、信息安全技术体系。");
            companyInfo.setVision("成为国内领先的数字科技服务商");
            companyInfo.setMission("用技术赋能企业数字化转型");
            companyInfo.setValues("诚信、创新、专业、共赢");
            companyInfo.setTechStack("AI、大数据、信创、信息安全、云计算、区块链");
            companyInfo.setServiceIndustries("银行、保险、证券基金、金融科技、互联网、新型制造、大数据");
            companyInfo.setCityCoverage("25+");
            companyInfo.setEmployeeCount("500+");
            companyInfo.setCustomerCount("数百家");
            companyInfo.setContactPhone("400-888-8888");
            companyInfo.setContactEmail("contact@cisetech.com");
            companyInfo.setAddress("上海市浦东新区张江高科技园区");
            companyInfo.setCopyright("© 2024 上海申朴信息技术股份有限公司 版权所有");
            companyInfo.setIcp("沪ICP备XXXXXXXX号");
            companyInfoRepository.save(companyInfo);
        }
    }

    private void initConfigs() {
        if (configRepository.count() == 0) {
            Config config1 = new Config();
            config1.setConfigKey("site.title");
            config1.setConfigValue("申朴信息 - 国内领先金融科技解决方案专家");
            config1.setDescription("网站标题");
            config1.setCategory("site");
            config1.setSortOrder(1);
            configRepository.save(config1);

            Config config2 = new Config();
            config2.setConfigKey("site.keywords");
            config2.setConfigValue("金融科技,数字化转型,AI赋能,信息安全,信创");
            config2.setDescription("网站关键词");
            config2.setCategory("site");
            config2.setSortOrder(2);
            configRepository.save(config2);

            Config config3 = new Config();
            config3.setConfigKey("site.description");
            config3.setConfigValue("申朴信息是国内领先的金融科技与企业数字化转型解决方案服务商，15年行业深耕经验。");
            config3.setDescription("网站描述");
            config3.setCategory("site");
            config3.setSortOrder(3);
            configRepository.save(config3);
        }
    }

    private void initBusinessServices() {
        if (businessServiceRepository.count() == 0) {
            String[] titles = {"数字化转型服务", "AI赋能服务", "信息安全服务", "信创适配服务", "ITO/BPO外包服务"};
            String[] slugs = {"digital-transformation", "ai-empowerment", "information-security", "xinchuang-adaptation", "outsourcing"};
            String[] icons = {"transform", "ai", "security", "xinchuang", "outsourcing"};
            String[] descriptions = {
                "企业全周期数字化转型定制方案，业务场景-技术应用全链条升级服务",
                "自有核心AI技术场景化定制，企业智能体系搭建，AI驱动业务升级服务",
                "网络安全监测、数据加密、安全风险排查、企业信息资产安全保障服务",
                "数据库信创全流程服务，含规划咨询、系统选型适配、应用开发迁移",
                "项目外包、人力外包、业务流程外包等多元化外包服务"
            };

            for (int i = 0; i < titles.length; i++) {
                BusinessService service = new BusinessService();
                service.setTitle(titles[i]);
                service.setSlug(slugs[i]);
                service.setDescription(descriptions[i]);
                service.setContent(descriptions[i]);
                service.setIcon(icons[i]);
                service.setCategory("core");
                service.setSortOrder(i + 1);
                businessServiceRepository.save(service);
            }
        }
    }

    private void initProducts() {
        if (productRepository.count() == 0) {
            String[] names = {"APM可观测平台", "AI辅助编程", "领域模型训练", "AI智能招投标助手", "SHS健康小站平台"};
            String[] slugs = {"apm-platform", "ai-coding", "domain-model", "ai-bidding", "shs-health"};
            String[] icons = {"monitor", "code", "brain", "bid", "health"};
            String[] categories = {"ai", "ai", "ai", "ai", "ai"};

            for (int i = 0; i < names.length; i++) {
                Product product = new Product();
                product.setName(names[i]);
                product.setSlug(slugs[i]);
                product.setDescription(names[i] + " - 申朴信息自研产品");
                product.setContent(names[i] + "详细介绍");
                product.setIcon(icons[i]);
                product.setCategory(categories[i]);
                product.setSortOrder(i + 1);
                productRepository.save(product);
            }
        }
    }

    private void initSolutions() {
        if (solutionRepository.count() == 0) {
            String[] titles = {"SME中小微产业金融系统", "业财一体化BI数据平台", "数据资产治理与建模", "人力资源管理SaaS平台"};
            String[] slugs = {"sme-finance", "finance-bi", "data-governance", "hr-saas"};
            String[] icons = {"finance", "bi", "data", "hr"};
            String[] industries = {"金融", "金融", "通用", "通用"};

            for (int i = 0; i < titles.length; i++) {
                Solution solution = new Solution();
                solution.setTitle(titles[i]);
                solution.setSlug(slugs[i]);
                solution.setDescription(titles[i] + " - 申朴信息行业解决方案");
                solution.setContent(titles[i] + "详细介绍");
                solution.setIcon(icons[i]);
                solution.setIndustry(industries[i]);
                solution.setCategory("finance");
                solution.setSortOrder(i + 1);
                solutionRepository.save(solution);
            }
        }
    }

    private void initQualifications() {
        if (qualificationRepository.count() == 0) {
            String[] names = {"高新技术企业", "软件企业认定", "专精特新中小企业", "ISO9001质量管理体系认证", "ISO27001信息安全管理体系认证"};
            String[] categories = {"tech", "tech", "tech", "iso", "iso"};

            for (int i = 0; i < names.length; i++) {
                Qualification qualification = new Qualification();
                qualification.setName(names[i]);
                qualification.setIssuingAuthority("国家相关部门");
                qualification.setDescription(names[i]);
                qualification.setCategory(categories[i]);
                qualification.setSortOrder(i + 1);
                qualificationRepository.save(qualification);
            }
        }
    }

    private void initAwards() {
        if (awardRepository.count() == 0) {
            String[] names = {"中国创新创业大赛优胜奖", "北交所&新三板年度风云榜", "上海市人工智能行业协会会员单位"};
            String[] categories = {"competition", "capital", "association"};
            int[] years = {2023, 2023, 2023};

            for (int i = 0; i < names.length; i++) {
                Award award = new Award();
                award.setName(names[i]);
                award.setIssuingOrganization("相关机构");
                award.setYear(years[i]);
                award.setDescription(names[i]);
                award.setCategory(categories[i]);
                award.setSortOrder(i + 1);
                awardRepository.save(award);
            }
        }
    }

    private void initServiceNetworks() {
        if (serviceNetworkRepository.count() == 0) {
            String[] cities = {"上海", "北京", "深圳", "杭州", "香港"};
            boolean[] isHeadquarters = {true, false, false, false, false};

            for (int i = 0; i < cities.length; i++) {
                ServiceNetwork network = new ServiceNetwork();
                network.setCity(cities[i]);
                network.setRegion("华东");
                network.setAddress(cities[i] + "市办公地址");
                network.setIsHeadquarters(isHeadquarters[i]);
                network.setSortOrder(i + 1);
                serviceNetworkRepository.save(network);
            }
        }
    }
}
