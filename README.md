## Responsive Shields for NeoForge
### Configurable reduction of the delay in Minecraft's blocking system

When holding use on an item, there is a base 'use time' which is stored and then decremented every tick while it's being held.
Minecraft will only block an attack after the shield has been raised for more than 5 ticks.
It checks this by looking at the difference between the current use time countdown and the base use time of the item.

(from LivingEntity's isBlocking() method)

> `return item.getUseDuration(this.useItem) - this.useItemRemaining >= 5;`

This mod uses a Mixin to change that number '5' to whatever you configure in the mod's config.

I think the reason Mojang did this was for balance reasons.
When it comes to singleplayer, though, having the delay set to 0 is really great for the more high-energy gameplay style encouraged by adventure modpacks and allows for some super clutch moments.

----------
## Configs
### Files and contents:
#### responsive-shields.toml

>`Raise Time`
>> (From 0 to 5. default: 0) The amount of time, in ticks, from when you right-click before the game will block attacks.

>`Enable`
>> (Default: true) Whether or not the effect of the mod is enabled.


### Info:
- Setting Raise Time to 0 makes shields capable of blocking immediately.


- Setting Raise Time to 5 is the same as vanilla.


- The client-side raise animation takes roughly one tick to complete. So setting Raise Time to 1 or 2 is a decent balance between responsiveness and not being able to blockhit as easily.