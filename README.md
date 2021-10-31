## Responsive Shields
### Configurable reduction of the delay on Minecraft's blocking system

Minecraft chooses to block an attack only after the shield has been raised for more than 5 ticks. This number is hard coded.
It checks this by looking at the difference between the current use time countdown and the base use time of the item.

(from LivingEntity) `return item.getUseDuration(this.useItem) - this.useItemRemaining >= 5;`

We can bypass this by skipping the current use time to the base use time minus 5 ticks; aka the threshold where the game will block attacks.
If you have the Raise Time setting higher than zero, my mod will wait to do that skip until you've had the shield raised for more than what Raise Time is set to. Enabling only a partial reduction of the delay.

I think the reason Mojang did this was for balance reasons. But honestly, even with the delay set to 0 (which, to be fair, I'm not sure is actually truely zero) it doesn't feel particularly overpowered, and is really suited to a more 'power user' gameplay style.

----------
#### Config:

Raise Time: The amount of time, in ticks, that the game waits from when you right click before it will block attacks.

Enable Delay Override: Whether or not the override logic will be skipped completely.

Raise Time is set to 0 ticks by default.

- Setting Raise Time to 5 has the same effect as disabling the mod using the Enable setting below it.
- Setting Raise Time to 0 makes shields capable of blocking instantaniously.
- The client-side raise animation takes roughly one tick to complete from the POV of the player. So setting Raise Time to 1 is a good balance between tactility and balance.
