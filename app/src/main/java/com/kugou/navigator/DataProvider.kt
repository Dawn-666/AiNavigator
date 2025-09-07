package com.kugou.navigator

object DataProvider {
    fun getAICategories(): List<AICategory> = listOf(
        AICategory(
            id = 1,
            name = "大语言模型",
            websites = listOf(
                AIWebsite(
                    id = 101,
                    name = "OpenAI",
                    url = "https://openai.com",
                    description = "GPT系列模型开发商",
                    category = "大语言模型",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://openai.com")
                ),
                AIWebsite(
                    id = 102,
                    name = "Hugging Face",
                    url = "https://huggingface.co",
                    description = "开源AI模型社区",
                    category = "大语言模型",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://huggingface.co")
                ),
                AIWebsite(
                    id = 103,
                    name = "Anthropic",
                    url = "https://www.anthropic.com",
                    description = "Claude AI助手",
                    category = "大语言模型",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.anthropic.com")
                ),
                // 国内大语言模型
                AIWebsite(
                    id = 104,
                    name = "文心一言",
                    url = "https://yiyan.baidu.com",
                    description = "百度推出的大语言模型",
                    category = "大语言模型",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://yiyan.baidu.com")
                ),
                AIWebsite(
                    id = 105,
                    name = "通义千问",
                    url = "https://qianwen.aliyun.com",
                    description = "阿里云推出的大语言模型",
                    category = "大语言模型",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://qianwen.aliyun.com")
                ),
                AIWebsite(
                    id = 106,
                    name = "讯飞星火",
                    url = "https://xinghuo.xfyun.cn",
                    description = "科大讯飞推出的大语言模型",
                    category = "大语言模型",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://xinghuo.xfyun.cn")
                ),
                AIWebsite(
                    id = 107,
                    name = "智谱清言",
                    url = "https://chatglm.cn",
                    description = "清华大学推出的大语言模型",
                    category = "大语言模型",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://chatglm.cn")
                ),
                AIWebsite(
                    id = 108,
                    name = "月之暗面",
                    url = "https://kimi.moonshot.cn",
                    description = "月之暗面推出的大语言模型",
                    category = "大语言模型",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://kimi.moonshot.cn")
                )
            )
        ),
        AICategory(
            id = 2,
            name = "计算机视觉",
            websites = listOf(
                AIWebsite(
                    id = 201,
                    name = "TensorFlow",
                    url = "https://www.tensorflow.org",
                    description = "谷歌机器学习框架",
                    category = "计算机视觉",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.tensorflow.org")
                ),
                AIWebsite(
                    id = 202,
                    name = "PyTorch",
                    url = "https://pytorch.org",
                    description = "Meta深度学习框架",
                    category = "计算机视觉",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://pytorch.org")
                ),
                // 国内计算机视觉平台
                AIWebsite(
                    id = 203,
                    name = "商汤科技",
                    url = "https://www.sensetime.com",
                    description = "领先的人工智能平台公司",
                    category = "计算机视觉",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.sensetime.com")
                ),
                AIWebsite(
                    id = 204,
                    name = "旷视科技",
                    url = "https://www.megvii.com",
                    description = "人工智能产品和解决方案提供商",
                    category = "计算机视觉",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.megvii.com")
                ),
                AIWebsite(
                    id = 205,
                    name = "依图科技",
                    url = "https://www.yitutech.com",
                    description = "人工智能算法提供商",
                    category = "计算机视觉",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.yitutech.com")
                ),
                AIWebsite(
                    id = 206,
                    name = "云从科技",
                    url = "https://www.cloudwalk.com",
                    description = "人机协同操作系统提供商",
                    category = "计算机视觉",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.cloudwalk.com")
                )
            )
        ),
        AICategory(
            id = 3,
            name = "AI智能体开发",
            websites = listOf(
                AIWebsite(
                    id = 301,
                    name = "LangChain",
                    url = "https://www.langchain.com",
                    description = "智能体开发框架",
                    category = "AI智能体开发",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.langchain.com")
                ),
                AIWebsite(
                    id = 302,
                    name = "LlamaIndex",
                    url = "https://www.llamaindex.ai",
                    description = "数据框架用于智能体",
                    category = "AI智能体开发",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.llamaindex.ai")
                ),
                // 国内智能体开发平台
                AIWebsite(
                    id = 303,
                    name = "面壁智能",
                    url = "https://www.minimax.com",
                    description = "智能体开发平台",
                    category = "AI智能体开发",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.minimax.com")
                ),
                AIWebsite(
                    id = 304,
                    name = "澜舟科技",
                    url = "https://www.langboat.com",
                    description = "自然语言处理平台",
                    category = "AI智能体开发",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.langboat.com")
                ),
                AIWebsite(
                    id = 305,
                    name = "聆心智能",
                    url = "https://www.lingxintech.com",
                    description = "AI对话系统开发平台",
                    category = "AI智能体开发",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.lingxintech.com")
                )
            )
        ),
        // 新增类别：AI绘画与设计
        AICategory(
            id = 4,
            name = "AI绘画与设计",
            websites = listOf(
                AIWebsite(
                    id = 401,
                    name = "文心一格",
                    url = "https://yige.baidu.com",
                    description = "百度AI绘画平台",
                    category = "AI绘画与设计",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://yige.baidu.com")
                ),
                AIWebsite(
                    id = 402,
                    name = "通义万相",
                    url = "https://wanxiang.aliyun.com",
                    description = "阿里云AI绘画平台",
                    category = "AI绘画与设计",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://wanxiang.aliyun.com")
                ),
                AIWebsite(
                    id = 403,
                    name = "稿定AI",
                    url = "https://www.gaoding.com/ai",
                    description = "AI设计工具平台",
                    category = "AI绘画与设计",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.gaoding.com")
                ),
                AIWebsite(
                    id = 404,
                    name = "触手AI",
                    url = "https://www.chushou.tv/ai",
                    description = "AI绘画创作平台",
                    category = "AI绘画与设计",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.chushou.tv")
                ),
                AIWebsite(
                    id = 405,
                    name = "Nolibox",
                    url = "https://www.nolibox.com",
                    description = "AI设计工具",
                    category = "AI绘画与设计",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.nolibox.com")
                )
            )
        ),
        // 新增类别：AI音频与视频
        AICategory(
            id = 5,
            name = "AI音频与视频",
            websites = listOf(
                AIWebsite(
                    id = 501,
                    name = "讯飞配音",
                    url = "https://peiyin.xunfei.cn",
                    description = "AI语音合成平台",
                    category = "AI音频与视频",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://peiyin.xunfei.cn")
                ),
                AIWebsite(
                    id = 502,
                    name = "腾讯智影",
                    url = "https://zenvideo.qq.com",
                    description = "AI视频创作平台",
                    category = "AI音频与视频",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://zenvideo.qq.com")
                ),
                AIWebsite(
                    id = 503,
                    name = "倒映有声",
                    url = "https://www.daoyingai.com",
                    description = "AI语音合成服务",
                    category = "AI音频与视频",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.daoyingai.com")
                ),
                AIWebsite(
                    id = 504,
                    name = "一帧秒创",
                    url = "https://aigc.yizhentv.com",
                    description = "AI视频创作工具",
                    category = "AI音频与视频",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://aigc.yizhentv.com")
                ),
                AIWebsite(
                    id = 505,
                    name = "魔音工坊",
                    url = "https://www.moyin.com",
                    description = "AI语音合成平台",
                    category = "AI音频与视频",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.moyin.com")
                )
            )
        ),
        // 新增类别：AI开发工具
        AICategory(
            id = 6,
            name = "AI开发工具",
            websites = listOf(
                AIWebsite(
                    id = 601,
                    name = "百度飞桨",
                    url = "https://www.paddlepaddle.org.cn",
                    description = "国产深度学习框架",
                    category = "AI开发工具",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.paddlepaddle.org.cn")
                ),
                AIWebsite(
                    id = 602,
                    name = "华为昇腾",
                    url = "https://www.hiascend.com",
                    description = "AI计算平台",
                    category = "AI开发工具",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.hiascend.com")
                ),
                AIWebsite(
                    id = 603,
                    name = "阿里云PAI",
                    url = "https://www.aliyun.com/product/bigdata/pai",
                    description = "机器学习平台",
                    category = "AI开发工具",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.aliyun.com")
                ),
                AIWebsite(
                    id = 604,
                    name = "腾讯云TI平台",
                    url = "https://cloud.tencent.com/product/tione",
                    description = "机器学习平台",
                    category = "AI开发工具",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://cloud.tencent.com")
                ),
                AIWebsite(
                    id = 605,
                    name = "OpenMMLab",
                    url = "https://openmmlab.com",
                    description = "开源计算机视觉算法库",
                    category = "AI开发工具",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://openmmlab.com")
                )
            )
        ),
        // 新增类别：AI应用平台
        AICategory(
            id = 7,
            name = "AI应用平台",
            websites = listOf(
                AIWebsite(
                    id = 701,
                    name = "讯飞开放平台",
                    url = "https://www.xfyun.cn",
                    description = "AI能力开放平台",
                    category = "AI应用平台",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.xfyun.cn")
                ),
                AIWebsite(
                    id = 702,
                    name = "百度AI开放平台",
                    url = "https://ai.baidu.com",
                    description = "AI技术开放平台",
                    category = "AI应用平台",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://ai.baidu.com")
                ),
                AIWebsite(
                    id = 703,
                    name = "阿里云智能",
                    url = "https://www.aliyun.com/product/ai",
                    description = "云计算AI服务平台",
                    category = "AI应用平台",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://www.aliyun.com")
                ),
                AIWebsite(
                    id = 704,
                    name = "腾讯AI开放平台",
                    url = "https://ai.qq.com",
                    description = "AI技术服务平台",
                    category = "AI应用平台",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://ai.qq.com")
                ),
                AIWebsite(
                    id = 705,
                    name = "京东AI研究院",
                    url = "https://neuhub.jd.com",
                    description = "AI技术研究与应用",
                    category = "AI应用平台",
                    faviconUrl = FaviconLoader.getFaviconUrl("https://neuhub.jd.com")
                )
            )
        )
    )
}