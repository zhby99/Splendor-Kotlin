package com.example.boyinzhang.splendor_kotlin.model

/**
 * Created by boyinzhang on 5/30/17.
 */

enum class Gem{
    DIAMOND {
        override fun getDeltaGemInfo(): GemInfo {
            return GemInfo(1,0,0,0,0);
        }
    },
    EMERALD {
        override fun getDeltaGemInfo(): GemInfo {
            return GemInfo(0,1,0,0,0);
        }
    },
    ONYX {
        override fun getDeltaGemInfo(): GemInfo {
            return GemInfo(0,0,1,0,0);
        }
    },
    RUBY {
        override fun getDeltaGemInfo(): GemInfo {
            return GemInfo(0,0,0,1,0);
        }
    },
    SAPPHIRE {
        override fun getDeltaGemInfo(): GemInfo {
            return GemInfo(0,0,0,0,1);
        }
    };

    public abstract fun getDeltaGemInfo():GemInfo


}
