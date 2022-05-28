# toko talk automation test

# Prerequisite
Using Java 8 or above

# Instruction (Mac OS)
Install Homebrew
$ brew install wget OR $ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)

# How to Run Test
- Clone this repo and enter the directory.
- git clone https://github.com/tnabror/tt.git
- cd tt
- gradle clean cucumber

If you want to run a specific tag. You can use tag properties.
- gradle clean cucumber --tags "@tagname"
example: gradle clean cucumber --tags="@AdminFeatures"
