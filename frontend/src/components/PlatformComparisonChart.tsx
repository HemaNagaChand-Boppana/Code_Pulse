import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
} from "recharts";

import type { Profile } from "../types/Profile";

type Props = {
  profile: Profile;
};

export default function PlatformComparisonChart({
  profile,
}: Props) {

  const data = profile.platforms.map((platform) => ({
    name: platform.platform,
    value:
      platform.currentRating > 0
        ? platform.currentRating
        : platform.totalSolved,
  }));

  return (
    <div className="bg-white rounded-xl shadow p-5">

      <h2 className="text-xl font-bold mb-4">
        Platform Comparison
      </h2>

      <div className="h-80">

        <ResponsiveContainer
          width="100%"
          height="100%"
        >

          <BarChart data={data}>

            <XAxis dataKey="name" />

            <YAxis />

            <Tooltip />

            <Bar dataKey="value" />

          </BarChart>

        </ResponsiveContainer>

      </div>

    </div>
  );
}