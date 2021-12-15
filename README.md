## Responsive Shields
### Configurable reduction of the delay on Minecraft's blocking system

When holding use on an item, there is a base 'use time' which is stored and then decremented every tick while it's being held.

I don't know what use this has on shields yet, but it is 72000 ticks nonetheless.

Minecraft chooses to block an attack only after the shield has been raised for more than 5 ticks.
It checks this by looking at the difference between the current use time countdown and the base use time of the item.

(from LivingEntity's isBlocking() method)
: `return item.getUseDuration(this.useItem) - this.useItemRemaining >= 5;`

We can bypass this by skipping the *current* use time to the *base use time minus 5 ticks*; aka the threshold where the game will block attacks.
This mod will only skip it ahead once you've had the shield raised for more than what `Raise Time` is set to. Which allows for an only partial reduction in delay.

I think the reason Mojang did this was for balance reasons. But honestly, even with the delay set to 0 (which, to be fair, I'm not sure is actually truely zero) it doesn't feel particularly overpowered, and is really great for the more high-energy gameplay style encouraged by adventure modpacks.

----------
### Config:

`Raise Time`
: The amount of time, in ticks, that the mod waits from when you right click before it will block attacks. (Default: 0)

`Enable Delay Override`
: Whether or not the override logic will be skipped completely. (Default: true)

- Setting Raise Time to 5 has the same effect as disabling the mod using the Enable setting below it.
- Setting Raise Time to 0 makes shields capable of blocking instantaneously.
- The client-side raise animation takes roughly one tick to complete from the POV of the player. So setting Raise Time to 1 is a good balance between tactility and balance.
