## Responsive Shields
### Configurable reduction of the delay in Minecraft's blocking system

When holding use on an item, there is a base 'use time' which is stored and then decremented every tick while it's being held.

I don't completely know what use this has on shields yet, but it is 72000 ticks nonetheless.

Minecraft will only block an attack after the shield has been raised for more than 5 ticks.
It checks this by looking at the difference between the current use time countdown and the base use time of the item.

(from LivingEntity's isBlocking() method)

> `return item.getUseDuration(this.useItem) - this.useItemRemaining >= 5;`

We can bypass this by skipping the *current* use time to the *base use time minus 5 ticks* when the player is hit, before the check takes place, thus, blocking the attack.
This mod will only skip it ahead once you've had the shield raised for more than what `Raise Time` is set to. Which enables an only partial reduction in delay, if you choose.

I think the reason Mojang did this was for balance reasons. But honestly, even with the delay set to 0 (which, to be fair, I'm not sure is actually truely zero) it doesn't feel particularly overpowered, and is really great for the more high-energy gameplay style encouraged by adventure modpacks.

----------
## Configs
### Files and contents:
#### responsive-shields.toml

>`Raise Time`
>> (From 0 to 5. default: 0) The amount of time, in ticks, from when you right-click before the game will block attacks.

>`Enable Delay Override`
>> (Default: true) Whether or not the effect of the mod is enabled.


### Info:
- Setting Raise Time to 0 makes shields capable of blocking immediately.


- Setting Raise Time to 5 is no different from not having the mod installed and is less efficient than setting the Enable setting to false. Both have the effect of disabling the mod's effects.


- The client-side raise animation takes roughly one tick to complete. So setting Raise Time to 1 is a decent balance between responsiveness and not being able to blockhit as easily - which I think was the original intention of the delay.