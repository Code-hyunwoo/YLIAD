import { useState } from "react";
import { BrowserView, MobileView } from "react-device-detect";
import { Link } from "react-router-dom";
import Navbar from "../components/layout/Navbar";
import base from "./Base.module.css";
import styles from "./Trash2.module.css";

function Trash2() {
  const [text, setText] = useState<string>("");
  const [isburned, setIsburned] = useState<boolean>(false);
  function burn() {
    setIsburned(true);
    // setIsburned((prev) => !prev);
    // console.log("clicked!", isburned);
  }
  function addTrash() {
    setIsburned(false);
    setText("");
  }
  return (
    <>
      <Navbar />
      <BrowserView>
        <div className={base.container}>
          <div className={styles.backP}></div>
          <div className={styles.lightP}></div>
          <div className={styles.contentP}>
            <div className={styles.fireP}>
              <div className={styles.bottomP}></div>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
            </div>
            <div className={styles.reverseP}>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
            </div>
          </div>
          <p className={styles.inputP}>
            지우고 싶은 기억을 입력하고 불태우세요..
            <br />
            <textarea />
            <button>불태워 지우기</button>
            <span className={styles.authorP}>Burn it</span>
            <Link to="/lobby">
              <button> 로비로 이동 </button>
            </Link>
          </p>
          <svg xmlns="http://www.w3.org/2000/svg" version="1.1">
            <defs>
              <filter id="goo">
                <feGaussianBlur
                  in="SourceGraphic"
                  stdDeviation="10"
                  result="blur"
                />
                <feColorMatrix
                  in="blur"
                  mode="matrix"
                  values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7"
                  result="goo"
                />
                <feBlend in="SourceGraphic" in2="goo" />
              </filter>
            </defs>
          </svg>
        </div>
      </BrowserView>

      <MobileView>
        <div className={base.container}>
          <div className={styles.back}></div>
          <div className={styles.light}></div>
          <div className={styles.content}>
            <div className={styles.fire}>
              <div className={styles.bottom}></div>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
              <figure></figure>
            </div>
            <div className={styles.reverse}>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
            </div>
          </div>
          <div className={styles.input}>
            <p>
              지우고 싶은 기억을
              <br />
              불태우세요
            </p>
            <textarea
              id={styles.text}
              name="textdiary"
              value={text}
              onChange={(ev: React.ChangeEvent<HTMLTextAreaElement>): void =>
                setText(ev.target.value)
              }
              className={isburned ? styles.burn : undefined}
            />
            <button onClick={addTrash}>추가 작성하기</button>
            <span className={styles.burnButton} onClick={burn}>
              Burn it
            </span>
            <Link to="/lobby">
              <button> 로비로 이동 </button>
            </Link>
          </div>
          <svg xmlns="http://www.w3.org/2000/svg" version="1.1">
            <defs>
              <filter id="goo">
                <feGaussianBlur
                  in="SourceGraphic"
                  stdDeviation="10"
                  result="blur"
                />
                <feColorMatrix
                  in="blur"
                  mode="matrix"
                  values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7"
                  result="goo"
                />
                <feBlend in="SourceGraphic" in2="goo" />
              </filter>
            </defs>
          </svg>
        </div>
      </MobileView>
    </>
  );
}

export default Trash2;
