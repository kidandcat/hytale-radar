# Hytale Radar

A Hytale server mod that shows all players on the HUD compass with real-time position tracking.

## Features

- Displays all online players on the top HUD compass bar
- Shows player name and distance (e.g. "PlayerName (42m)")
- Real-time position updates (every 500ms)
- Automatically enabled for all players - no commands needed

## Requirements

- Java 21
- HytaleServer.jar (place in `libs/` folder)

## Building

```bash
./gradlew build
```

The output JAR will be in `build/libs/HytaleRadar-1.0.0.jar`

## Installation

Copy the built JAR to your Hytale server's `Mods` folder.

## License

MIT
