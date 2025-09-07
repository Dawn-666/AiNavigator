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
                )
            )
        )
    )
}