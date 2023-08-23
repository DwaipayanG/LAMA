export default function Starlight() {
    /*
      Generating Starlight:
      We need a x and y cordinate, so we randomly get location of top and left to position our star.
      To keep a variable size between 5px to 10px we randomly choose a size between this.
      Timing helps us in delaying the animation randomly to give it a more organic feel of starlight flickering.
      Different shade of yellow and orange to mimic starlight at night.
    */
    let locLeft = Math.random() * (window.innerWidth-15); //to get a random left position of star
    let locTop = Math.random() * (window.innerHeight-15) + 150; //to get a ranodme right position of star
    let size = Math.random() * 5+ 2;
    let timing = Math.random() * 3;
    let colors = [
      "#d5c64f",
      "#d5c64f",
      "#d5c64f",
      "#daea48",
      "#daea48",
      "#94e423",
    ];
    let colorStar = colors[Math.floor(Math.random() * 6)];
    return (
      <div
        className="starlight"
        style={{
          top: locTop,
          left: locLeft,
          width: size,
          height: size,
          animationDelay: timing,
          backgroundColor: colorStar,
        }}
        aria-hidden="true"
      ></div>
    );
  }