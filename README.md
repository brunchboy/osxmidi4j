deprecated: osxmidi4j
=========

I had forked this project in order to update it to work on current versions of Mac OS X, and add support for adding and removing MIDI devices without restarting the Java environment, but it turns out this embeds far too many commonly used packages to be safely placed on the Java extension path, so it has been replaced with an entirely new package.

Please use [CoreMIDI4J](https://github.com/DerekCook/CoreMidi4J) instead.
