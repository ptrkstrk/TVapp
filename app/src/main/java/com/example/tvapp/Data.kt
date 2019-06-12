package com.example.tvapp

class Data {

    companion object {
        const val SWORD_URL = "https://gamepedia.cursecdn.com/minecraft_gamepedia/a/a0/Diamond_Sword.png?version=d3b1fbce65ce732c68aa8b544c1b081c"//https://gamepedia.cursecdn.com/minecraft_gamepedia/c/cd/Wooden_Sword.png
        const val SWORD_NAME = "Sword"
        const val SHOVEL_URL = "https://gamepedia.cursecdn.com/minecraft_gamepedia/a/a4/Wooden_Shovel.png"
        const val SHOVEL_NAME = "Shovel"
        const val PICKAXE_URL = "https://gamepedia.cursecdn.com/minecraft_gamepedia/b/b3/Wooden_Pickaxe.png"
        const val PICKAXE_NAME = "Pickaxe"
        const val AXE_URL = "https://gamepedia.cursecdn.com/minecraft_gamepedia/1/11/Wooden_Axe.png"
        const val AXE_NAME = "Axe"

        const val DIRT_URL = "https://gamepedia.cursecdn.com/minecraft_gamepedia/2/2f/Dirt.png"
        const val DIRT_NAME = "Dirt"
        const val COBBLESTONE_URL = "https://gamepedia.cursecdn.com/minecraft_gamepedia/6/67/Cobblestone.png"
        const val COBBLESTONE_NAME = "Cobblestone"
        const val WOOD_URL = "https://gamepedia.cursecdn.com/minecraft_gamepedia/c/c1/Oak_Planks.png"
        const val WOOD_NAME = "Wood"
        const val DIAMOND_URL = "https://gamepedia.cursecdn.com/minecraft_gamepedia/9/97/Diamond_Ore.png"
        const val DIAMOND_NAME = "Diamond Ore"

        const val PORKCHOP_URL = "https://gamepedia.cursecdn.com/minecraft_gamepedia/2/28/Raw_Porkchop.png"
        const val PORKCHOP_NAME = "Porkchop"
        const val CHICKEN_URL = "https://gamepedia.cursecdn.com/minecraft_gamepedia/c/c1/Cooked_Chicken.png"
        const val CHICKEN_NAME = "Chicken"
        const val APPLE_URL = "https://gamepedia.cursecdn.com/minecraft_gamepedia/7/7d/Apple.png"
        const val APPLE_NAME = "Apple"
        const val COOKIE_URL = "https://gamepedia.cursecdn.com/minecraft_gamepedia/7/70/Cookie.png"
        const val COOKIE_NAME = "Cookie"

        fun prepareToolsData(tools:ArrayList<Pair<String,String>>) {
            tools.add(Pair(Data.SWORD_URL, Data.SWORD_NAME))
            tools.add(Pair(Data.PICKAXE_URL, Data.PICKAXE_NAME))
            tools.add(Pair(Data.AXE_URL, Data.AXE_NAME))
            tools.add(Pair(Data.SHOVEL_URL, Data.SHOVEL_NAME))
        }

        fun prepareBlocksData(blocks:ArrayList<Pair<String,String>>) {
            blocks.add(Pair(Data.COBBLESTONE_URL, Data.COBBLESTONE_NAME))
            blocks.add(Pair(Data.WOOD_URL, Data.WOOD_NAME))
            blocks.add(Pair(Data.DIAMOND_URL, Data.DIAMOND_NAME))
            blocks.add(Pair(Data.DIRT_URL, Data.DIRT_NAME))

        }

        fun prepareFoodData(foods:ArrayList<Pair<String,String>>) {
            foods.add(Pair(Data.PORKCHOP_URL, Data.PORKCHOP_NAME))
            foods.add(Pair(Data.APPLE_URL, Data.APPLE_NAME))
            foods.add(Pair(Data.CHICKEN_URL, Data.CHICKEN_NAME))
            foods.add(Pair(Data.COOKIE_URL, Data.COOKIE_NAME))
        }
    }
}