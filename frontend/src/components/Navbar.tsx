import { Link, useLocation } from "react-router-dom";

export default function Navbar() {
  const location = useLocation();

  const navItemClass = (path: string) =>
    `px-4 py-2 rounded-lg transition ${
      location.pathname === path
        ? "bg-blue-600 text-white"
        : "text-gray-700 hover:bg-gray-100"
    }`;

  return (
    <nav className="bg-white border-b shadow-sm">
      <div className="max-w-7xl mx-auto px-6 h-16 flex items-center justify-between">
        
        <div className="text-2xl font-bold text-blue-600">
          CodePulse
        </div>

        <div className="flex gap-3">
          <Link to="/" className={navItemClass("/")}>
            Dashboard
          </Link>

          <Link
            to="/leaderboard"
            className={navItemClass("/leaderboard")}
          >
            Leaderboard
          </Link>

          <Link
            to="/settings"
            className={navItemClass("/settings")}
          >
            Settings
          </Link>
        </div>
      </div>
    </nav>
  );
}